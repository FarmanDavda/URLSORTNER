package com.info.urlshortner.service;

import com.google.common.hash.Hashing;
import com.info.urlshortner.Dto.Urldto;
import com.info.urlshortner.entity.Url;
import com.info.urlshortner.repository.UrlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UrlServiceimpl implements UrlService {
    @Autowired
    UrlRepo service;
    @Override
    public ResponseEntity<?> createurl(Urldto urldto) {
        String sortUrl=sortUrl(urldto.getOriginal(),urldto.getExpiredate());
        Url url=new Url();//we can create Url Entity Object for db opration
        url.setOriginal(urldto.getOriginal());// set orignal url
//        LocalDateTime obj = LocalDateTime.now();
        url.setCurrnetdate(LocalDateTime.now());//set current date
        url.setShorturl(sortUrl);//set sort url we was recived by sortUrl function
        Url save = service.save(url);//and save in db using save method
        if(save!=null){
        return new ResponseEntity<>(url, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public String sendpage(String shorturl) {
        Optional<Url> byShortUrl = service.findByShorturl(shorturl);
        if(byShortUrl.isPresent()){
            Url url = byShortUrl.get();
            String original = url.getOriginal();
            return original;
        }
        return "error";
    }

    private String sortUrl(String original, LocalDateTime expiredate) {
     String encoderurl="";
        LocalDateTime time=LocalDateTime.now();
        encoderurl= Hashing.murmur3_32().hashString(original.concat(time.toString()),
        StandardCharsets.UTF_8).toString();
        return encoderurl;
    }
}
