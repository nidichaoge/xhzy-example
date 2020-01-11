package com.mouse.xhzy.video.javacv.controller;

import com.mouse.xhzy.video.javacv.entity.VideoInfo;
import com.mouse.xhzy.video.javacv.util.VideoInfoUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mouse
 * @version 1.0
 * @date 2020-01-11
 * @description
 */
@RestController
@RequestMapping("/video")
public class VideoController {

    /**
     * 获得视频信息,支持HTTP格式的地址
     * https://test-fenfa.oss-cn-hangzhou.aliyuncs.com/mouse/2.mp4
     *
     * @param videoUrl
     * @return
     */
    @GetMapping("/info")
    public VideoInfo getVideoInfo(@RequestParam String videoUrl) {
        return VideoInfoUtil.getVideoInfo(videoUrl);
    }

}
