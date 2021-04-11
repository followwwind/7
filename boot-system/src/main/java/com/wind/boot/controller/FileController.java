package com.wind.boot.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.wind.boot.config.Constants;
import com.wind.boot.config.exception.BusinessException;
import com.wind.boot.config.message.HttpCode;
import com.wind.boot.config.message.JsonResult;
import com.wind.boot.entity.vo.ExcelVO;
import com.wind.boot.util.IdGenUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Title: FileController
 * @Package com.wind.business.controller
 * @Description: 文件上传
 * @author wind
 * @date 2018/10/30 13:49
 * @version V1.0
 */
@RestController
@RequestMapping(value = "api/file")
public class FileController {

    private Logger logger = LoggerFactory.getLogger(FileController.class);

    @Value("${file.file}")
    private String filePath;

    @Value("${file.url}")
    private String url;


    /**
     * 文件上传
     * @param files
     * @return
     */
    @RequestMapping(value = "uploadFile", method = RequestMethod.POST)
    public JsonResult uploadFile(@RequestParam(value = "files", required = false) MultipartFile[] files) {
        logger.info("FileController.uploadFile");
        List<String> list = new ArrayList<>();
        if(files != null){
            File imgFile = new File(filePath);
            if(!imgFile.exists()){
                imgFile.mkdirs();
            }
            for(MultipartFile file : files){
                if (!file.isEmpty()) {
                    String originalName = file.getOriginalFilename();
                    int index = originalName.lastIndexOf(46);
                    if(index > -1){
                        String suffix = originalName.substring(index);
                        String fileName = IdGenUtil.getUUID() + suffix;
                        try {
                            file.transferTo(new File(filePath + fileName));
                            list.add(url + "file/" + fileName);
                        } catch (IOException e) {
                            logger.error(e.getMessage());
                        }
                    }
                }
            }
        }
        JsonResult jsonResult = HttpCode.FAIL.getJsonResult();
        if(!list.isEmpty()){
            jsonResult = new JsonResult(HttpCode.OK);
            Optional<String> opt = list.stream().reduce((a, b) -> a + Constants.COMMA_STR + b);
            opt.ifPresent(jsonResult::setData);
        }

        return jsonResult;
    }

    /**
     * 文件下载
     * @param fileName
     * @param response
     */
    @GetMapping("downFile/{fileName:.+}")
    public void downFile(@PathVariable("fileName") String fileName, HttpServletResponse response){
        logger.info("FileController.downFile params: fileName is {}", fileName);
        down(filePath, fileName, response);
    }


    /**
     * 下载
     * @param path
     * @param fileName
     * @param response
     */
    private void down(String path, String fileName, HttpServletResponse response){
        File file = new File(path + fileName);
        if (file.exists()) {
            //设置响应头
            // 设置强制下载不打开
            response.setContentType("application/force-download");
            // 设置文件名
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
            response.setHeader("Context-Type", "application/xmsdownload");
            byte[] buffer = new byte[1024];
            try(
                    FileInputStream fis = new FileInputStream(file);
                    BufferedInputStream bis = new BufferedInputStream(fis);
            ) {
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }else{
            throw new BusinessException("文件不存在");
        }
    }

    /**
     * excel文件导出
     * @param response
     */
    @RequestMapping(value = "excel/export", method = {RequestMethod.POST, RequestMethod.GET})
    public void excelExport(HttpServletResponse response) throws IOException {
        logger.info("FileController.excelExport");
        // 设置文件名
        response.addHeader("Content-Disposition", "attachment;fileName=record.xls");
        response.setHeader("Context-Type", "application/vnd.ms-excel");
        List<ExcelVO> list = new ArrayList<>();
        ExcelVO vo = new ExcelVO();
        list.add(vo);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("333", "cici"),
                ExcelVO.class, list);
        workbook.write(response.getOutputStream());
    }

}
