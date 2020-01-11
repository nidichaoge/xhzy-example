package com.mouse.xhzy.video.javacv.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-01-11
 * @description
 */
@Data
@Builder
public class VideoInfo {

    private String url;

    /**
     * 宽
     */
    private int imageWidth;

    /**
     * 高
     */
    private int imageHeight;

    /**
     * 帧率 25.0
     */
    private double frameRate;

    /**
     * 总帧数
     */
    private int lengthInFrames;

    /**
     * 视频总帧数
     */
    private int lengthInVideoFrames;

    /**
     * 音频总帧数
     */
    private int lengthInAudioFrames;

    /**
     * 视频时长
     */
    private long lengthInTime;

    /**
     * 所有信息 JSON格式
     */
    private String detail;

}
