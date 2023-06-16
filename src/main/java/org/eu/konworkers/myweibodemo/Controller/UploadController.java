package org.eu.konworkers.myweibodemo.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.eu.konworkers.myweibodemo.domain.enties.MessageConstants;
import org.eu.konworkers.myweibodemo.domain.enties.Result;
import org.eu.konworkers.myweibodemo.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class UploadController {

    @Autowired
    private ObjectMapper objectmapper;

    @RequestMapping("/updateicon")
    public Result updateicon(MultipartFile imgFile) throws IOException {
        //token : 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

        byte[] fileBytes = imgFile.getBytes();
        byte[] encodedBytes = Base64.encodeBase64(fileBytes);
        String content = new String(encodedBytes);

        Map<String,Object> committer = new HashMap<>();
        committer.put("name","1502020011");
        committer.put("email","1502020011@mail.bnuz.edu.cn");

        Map<String,Object> jsonmap = new HashMap<>();
        jsonmap.put("message","upload by J105");
        jsonmap.put("committer",committer);
        jsonmap.put("content",content);

        String json = objectmapper.writeValueAsString(jsonmap);
        String filename = UUID.randomUUID().toString().replace("-","")+"-"+imgFile.getOriginalFilename();
        String url = "https://api.github.com/repos/1502020011/MyWeiboDemoImageRepository/contents/"+filename;

        UploadUtils uploadutils = new UploadUtils(url,json);

        try {
            String githubcontent = uploadutils.run();
            Map<String, Object> githubcontentMap = objectmapper.readValue(githubcontent, HashMap.class);
            Map<String,Object> content1 = (Map<String, Object>) githubcontentMap.get("content");
            String downloadUrl = (String) content1.get("download_url");

            return new Result(true, MessageConstants.UPLOAD_SUCCESS,downloadUrl);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false, MessageConstants.UPLOAD_FAIL);
        }
    }
}
