package com.mouse.xhzy.video.javacv.util;

import com.alibaba.fastjson.JSON;
import com.mouse.xhzy.video.javacv.entity.VideoInfo;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FrameGrabber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-01-11
 * @description
 */
public class VideoInfoUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(VideoInfoUtil.class);

    public static VideoInfo getVideoInfo(String videoUrl) {
        FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(videoUrl);
        try {
            grabber.start();
            VideoInfo videoInfo = VideoInfo.builder()
                    .url(videoUrl)
                    .imageWidth(grabber.getImageWidth())
                    .imageHeight(grabber.getImageHeight())
                    .frameRate(grabber.getFrameRate())
                    .lengthInTime(grabber.getLengthInTime())
                    .lengthInAudioFrames(grabber.getLengthInAudioFrames())
                    .lengthInVideoFrames(grabber.getLengthInVideoFrames())
                    .lengthInFrames(grabber.getLengthInFrames())
                    .detail(JSON.toJSONString(grabber))
                    .build();
            LOGGER.info("videoInfo:{}.", videoInfo);
            return videoInfo;
        } catch (Exception e) {
            LOGGER.error("Get video info failed. ErrorMsg:{}", e.getMessage());
        } finally {
            try {
                grabber.stop();
            } catch (FrameGrabber.Exception e) {
                LOGGER.error("Stop grabber failed. ErrorMsg:{}.", e.getMessage());
            }
        }
        return null;
    }

}
