package com.fathua.o2o.utils;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 图片处理工具类
 *
 * @author JIDI
 */
public class ImageUtil {
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();

    /**
     * 生成缩略图
     *
     * @param thumbnailInputStream
     * @param targetAddr
     * @return
     */
    public static String generateThumbnail(InputStream thumbnailInputStream, String fileName, String targetAddr) {
        String srcFileName = getRandomFileName();
        String extension = getFileExtension(fileName);
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + srcFileName + extension;
        File destFile = new File(PathUtil.getImgBasePath() + relativeAddr);
        try {
            Thumbnails.of(thumbnailInputStream).size(200, 200).watermark(Positions.TOP_RIGHT,
                    ImageIO.read(new File(basePath + "//watermark.jpg")), 0.25f).outputQuality(0.8f).toFile(destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return relativeAddr;

    }

    /**
     * 创建目标路径所涉及到的目录
     *
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
       String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
       File dirPath = new File(realFileParentPath);
       if (!dirPath.exists()) {
           dirPath.mkdirs();
       }
    }

    /**
     * 获取文件流的扩展名
     * @param fileName
     * @return
     */
    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成随机文件名，当前年月日小时分秒 + 5位随机数
     *
     * @return
     */
    public static String getRandomFileName() {
        // 获取5位随机数
        int rannum = r.nextInt(89999) + 10000;
        String nowTimeStr = sDateFormat.format(new Date());
        return nowTimeStr + rannum;
    }

    public static void main(String[] args) throws IOException {
        Thumbnails.of(new File("E://temp//image//a-01.jpg")).size(200, 200).watermark(Positions.TOP_RIGHT,
                ImageIO.read(new File(basePath + "//watermark.jpg")), 0.25f).outputQuality(0.8f).toFile("E://temp" +
                "//image//a-01-new.jpg");
    }
}
