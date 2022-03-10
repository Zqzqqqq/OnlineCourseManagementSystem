package com.zhouqi.onlinecourseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.luck.picture.lib.app.PictureAppMaster;
import com.luck.picture.lib.basic.PictureSelector;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.MediaExtraInfo;
import com.luck.picture.lib.interfaces.OnExternalPreviewEventListener;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.luck.picture.lib.utils.MediaUtils;

import java.util.ArrayList;
import java.util.List;

public class PublishUnitActivity extends AppCompatActivity implements View.OnClickListener {

    TextView confirm;
    ImageButton addTest;
    private GridImageAdapter textAdapter;
    private GridImageAdapter videoAdapter;
    private final List<LocalMedia> textData = new ArrayList<>();
    private final List<LocalMedia> videoData = new ArrayList<>();
    RecyclerView TextRecyclerView;
    RecyclerView VideoRecyclerView;
    Dialog inputTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_unit);
        confirm = findViewById(R.id.text_confirm);
        addTest = findViewById(R.id.add_test);
        confirm.setOnClickListener(this);
        addTest.setOnClickListener(this);


        TextRecyclerView = findViewById(R.id.recycler_text);
        FullyGridLayoutManager manager = new FullyGridLayoutManager(this,
                4, GridLayoutManager.VERTICAL, false);
        TextRecyclerView.setLayoutManager(manager);
        textAdapter = new GridImageAdapter(this, textData);
        textAdapter.setSelectMax(1);
        TextRecyclerView.setAdapter(textAdapter);

        VideoRecyclerView = findViewById(R.id.recycler_video);
        FullyGridLayoutManager manager1 = new FullyGridLayoutManager(this,
                4, GridLayoutManager.VERTICAL, false);
        VideoRecyclerView.setLayoutManager(manager1);
        videoAdapter = new GridImageAdapter(this, videoData);
        videoAdapter.setSelectMax(1);
        VideoRecyclerView.setAdapter(videoAdapter);

        textAdapter.setOnItemClickListener(new GridImageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                // 预览图片、视频、音频
                PictureSelector.create(PublishUnitActivity.this)
                        .openPreview()
                        .setImageEngine(GlideEngine.createGlideEngine())
                        .isPreviewFullScreenMode(true)
                        .setExternalPreviewEventListener(new OnExternalPreviewEventListener() {
                            @Override
                            public void onPreviewDelete(int position) {
                                textAdapter.remove(position);
                                textAdapter.notifyItemRemoved(position);
                            }

                            @Override
                            public boolean onLongPressDownload(LocalMedia media) {
                                return false;
                            }
                        })
                        .startActivityPreview(position, true, textAdapter.getData());
            }

            @Override
            public void openPicture() {
                getSystemAlbum(0);
            }
        });

        videoAdapter.setOnItemClickListener(new GridImageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                // 预览图片、视频、音频
                PictureSelector.create(PublishUnitActivity.this)
                        .openPreview()
                        .setImageEngine(GlideEngine.createGlideEngine())
                        .isPreviewFullScreenMode(true)
                        .setExternalPreviewEventListener(new OnExternalPreviewEventListener() {
                            @Override
                            public void onPreviewDelete(int position) {
                                videoAdapter.remove(position);
                                videoAdapter.notifyItemRemoved(position);
                            }

                            @Override
                            public boolean onLongPressDownload(LocalMedia media) {
                                return false;
                            }
                        })
                        .startActivityPreview(position, true, videoAdapter.getData());
            }

            @Override
            public void openPicture() {
                getSystemAlbum(1);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add_test:
                inputTest = new TestInputDialog(this,0,this);
                inputTest.show();
        }
    }

    private void getSystemAlbum(int i) {
        if(i==0) {
            PictureSelector.create(this)
                    .openSystemGallery(SelectMimeType.ofImage())
                    .forSystemResult(new OnResultCallbackListener<LocalMedia>() {
                        @Override
                        public void onResult(ArrayList<LocalMedia> result) {
                            System.out.println(result.get(0).getPath());
                            for (LocalMedia media : result) {
                                if (media.getWidth() == 0 || media.getHeight() == 0) {
                                    if (PictureMimeType.isHasImage(media.getMimeType())) {
                                        MediaExtraInfo imageExtraInfo = MediaUtils.getImageSize(media.getPath());
                                        media.setWidth(imageExtraInfo.getWidth());
                                        media.setHeight(imageExtraInfo.getHeight());
                                    } else if (PictureMimeType.isHasVideo(media.getMimeType())) {
                                        MediaExtraInfo videoExtraInfo = MediaUtils.getVideoSize(PictureAppMaster.getInstance().getAppContext(), media.getPath());
                                        media.setWidth(videoExtraInfo.getWidth());
                                        media.setHeight(videoExtraInfo.getHeight());
                                    }
                                }
                            }
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    boolean isMaxSize = result.size() == textAdapter.getSelectMax();
                                    int oldSize = textAdapter.getData().size();
                                    textAdapter.notifyItemRangeRemoved(0, isMaxSize ? oldSize + 1 : oldSize);
                                    textAdapter.getData().clear();

                                    textAdapter.getData().addAll(result);
                                    textAdapter.notifyItemRangeInserted(0, result.size());
                                }
                            });
                        }

                        @Override
                        public void onCancel() {

                        }
                    });
        }else if(i==1){
            PictureSelector.create(this)
                    .openSystemGallery(SelectMimeType.ofImage())
                    .forSystemResult(new OnResultCallbackListener<LocalMedia>() {
                        @Override
                        public void onResult(ArrayList<LocalMedia> result) {
                            System.out.println(result.get(0).getPath());
                            for (LocalMedia media : result) {
                                if (media.getWidth() == 0 || media.getHeight() == 0) {
                                    if (PictureMimeType.isHasImage(media.getMimeType())) {
                                        MediaExtraInfo imageExtraInfo = MediaUtils.getImageSize(media.getPath());
                                        media.setWidth(imageExtraInfo.getWidth());
                                        media.setHeight(imageExtraInfo.getHeight());
                                    } else if (PictureMimeType.isHasVideo(media.getMimeType())) {
                                        MediaExtraInfo videoExtraInfo = MediaUtils.getVideoSize(PictureAppMaster.getInstance().getAppContext(), media.getPath());
                                        media.setWidth(videoExtraInfo.getWidth());
                                        media.setHeight(videoExtraInfo.getHeight());
                                    }
                                }
                            }
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    boolean isMaxSize = result.size() == videoAdapter.getSelectMax();
                                    int oldSize = textAdapter.getData().size();
                                    videoAdapter.notifyItemRangeRemoved(0, isMaxSize ? oldSize + 1 : oldSize);
                                    videoAdapter.getData().clear();

                                    videoAdapter.getData().addAll(result);
                                    videoAdapter.notifyItemRangeInserted(0, result.size());
                                }
                            });
                        }

                        @Override
                        public void onCancel() {

                        }
                    });
        }

    }

    /*@Override
    public void onSelectFinish(@Nullable PictureCommonFragment.SelectorResult result) {
        if (result == null) {
            return;
        }
        if (result.mResultCode == RESULT_OK) {
            ArrayList<LocalMedia> selectorResult = PictureSelector.obtainSelectorList(result.mResultData);
            analyticalSelectResults(selectorResult);
        } else if (result.mResultCode == RESULT_CANCELED) {

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == PictureConfig.CHOOSE_REQUEST || requestCode == PictureConfig.REQUEST_CAMERA) {
                ArrayList<LocalMedia> result = PictureSelector.obtainSelectorList(data);
                analyticalSelectResults(result);
            }
        } else if (resultCode == RESULT_CANCELED) {

        }
    }

    *//**
     * 处理选择结果
     *
     * @param result
     *//*
    private void analyticalSelectResults(ArrayList<LocalMedia> result) {
        for (LocalMedia media : result) {
            if (media.getWidth() == 0 || media.getHeight() == 0) {
                if (PictureMimeType.isHasImage(media.getMimeType())) {
                    MediaExtraInfo imageExtraInfo = MediaUtils.getImageSize(media.getPath());
                    media.setWidth(imageExtraInfo.getWidth());
                    media.setHeight(imageExtraInfo.getHeight());
                } else if (PictureMimeType.isHasVideo(media.getMimeType())) {
                    MediaExtraInfo videoExtraInfo = MediaUtils.getVideoSize(PictureAppMaster.getInstance().getAppContext(), media.getPath());
                    media.setWidth(videoExtraInfo.getWidth());
                    media.setHeight(videoExtraInfo.getHeight());
                }
            }
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                boolean isMaxSize = result.size() == mAdapter.getSelectMax();
                int oldSize = mAdapter.getData().size();
                mAdapter.notifyItemRangeRemoved(0, isMaxSize ? oldSize + 1 : oldSize);
                mAdapter.getData().clear();

                mAdapter.getData().addAll(result);
                mAdapter.notifyItemRangeInserted(0, result.size());
            }
        });
    }*/
}