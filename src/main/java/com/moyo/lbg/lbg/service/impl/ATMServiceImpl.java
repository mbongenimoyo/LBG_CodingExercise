package com.moyo.lbg.lbg.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moyo.lbg.lbg.aspects.TrackExecutionTime;
import com.moyo.lbg.lbg.models.ATMModel;
import com.moyo.lbg.lbg.models.RequestModel;
import com.moyo.lbg.lbg.models.ContentsModel;
import com.moyo.lbg.lbg.service.ATMService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;


import javax.management.BadAttributeValueExpException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class ATMServiceImpl implements ATMService {
    private final Logger Logger= LogManager.getLogger(ATMServiceImpl.class);
    @Autowired
    private ObjectMapper mapper;

    @Override
    @TrackExecutionTime
    public ArrayList<ATMModel> getById(RequestModel requestModel) throws IOException, BadAttributeValueExpException {
        ContentsModel r= mapper.readValue(MakeUrlRequest(requestModel.getUrl()), ContentsModel.class);
        ArrayList<ATMModel> atmList=r.getData().get(0).getBrandModel().get(0).getATM();
        return searchAtmById(mapAtmsToId(atmList),requestModel.getIdentification());

    }

    public Map<String, ArrayList<ATMModel>> mapAtmsToId(ArrayList<ATMModel> atmDTOArrayList){
        HashMap<String,ArrayList<ATMModel>> result=new HashMap<>();
        for(ATMModel atm:atmDTOArrayList){
            String identification=atm.getIdentification();
            if(result.containsKey(identification)){
                result.get(identification).add(atm);
            }
            else{
                ArrayList<ATMModel> temp= new ArrayList<>();
                temp.add(atm);
                result.put(identification,temp);
            }
        }
        return result;
    }



    public ArrayList<ATMModel> searchAtmById(Map<String, ArrayList<ATMModel>> map, String id) throws BadAttributeValueExpException {
        final StopWatch stopWatch = new StopWatch();
        Logger.info("started...Function : searchAtmById()");
        stopWatch.start();
        ArrayList<ATMModel> x=map.get(id);
        if(x.isEmpty()){
            throw  new BadAttributeValueExpException("invalid id");
        }
        stopWatch.stop();
        Logger.info("...Finished: searchAtmById(). Execution Time:"+stopWatch.getTotalTimeMillis());
        return x;
    }



    private String MakeUrlRequest(String s) throws IOException {
        final StopWatch stopWatch = new StopWatch();
        Logger.info("started....Function : MakeUrlRequest() -started....");
        stopWatch.start();
        URL url= new URL(s);
        HttpURLConnection con=(HttpURLConnection) url.openConnection();
        con.setRequestMethod(HttpMethod.GET.name());
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        stopWatch.stop();
        Logger.info("...Finished: MakeUrlRequest(). Execution Time:"+stopWatch.getTotalTimeMillis());
        return content.toString();
    }
}
