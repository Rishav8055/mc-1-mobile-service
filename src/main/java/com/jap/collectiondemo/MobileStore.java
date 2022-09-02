package com.jap.collectiondemo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MobileStore {


    private List<Mobile> allMobiles;
    private String record = "";
    private String splitBy = ",";
    public MobileStore()
    {
        allMobiles = new ArrayList<>();
    }

    //Write logic to read the fileName that is "mobile.csv"
    //read all the lines one by one
    //Create Mobile class object and store data from file in the respective attributes of Mobile class
    // ex - Store brandName - Samsung in  mobile.setBrandName(brandName);
    //add mobile object in the List object and return the List
    //handle all the exceptions
    public List<Mobile> readMobileData(String fileName) {
        Mobile[] mobiles= null;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader =new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while ((line=bufferedReader.readLine())!=null){
                ////re-initializing file-reader and buffer reader
                fileReader=new FileReader(fileName);
                bufferedReader=new BufferedReader(fileReader);
                line=bufferedReader.readLine();
                int index=0;
                while ((line=bufferedReader.readLine())!=null){
                    String[] split = line.split(",");
                    String brandName=split[0];
                    String modelName=split[1];
                    double cost=Double.parseDouble(split[2]);
                    String screenSize=split[3];
                    String batteryLife=split[4];
                    String storageSpace=split[5];
                    int    cameraPixels=Integer.parseInt(split[6]);
                    allMobiles.add(new Mobile(brandName,modelName,cost,screenSize,batteryLife,storageSpace,cameraPixels));
                    index++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return allMobiles;
    }

    //Iterate the List created in the above method and retrieve the bandName
    //Return the List with specific Mobile having brandName coming from method parameter
    public List<Mobile> findPhoneByBrand(String brandName)
    {
        List<Mobile> mobilesByBrand = new ArrayList<>();
        Iterator<Mobile>iterator=allMobiles.iterator();
        while (iterator.hasNext()){
            Mobile mobile= iterator.next();
            if (mobile.getBrandName().equals(brandName)){
                mobilesByBrand.add(mobile);
            }
        }

        return mobilesByBrand;
    }

    //Iterate through the List created in the first method
    //Return the List of Mobile whose cost is more than $500
    public List<Mobile> findPhoneCostMoreThan$500()
    {
        List<Mobile> mobilesMoreThan500 = new ArrayList<>();
        Iterator<Mobile> iterator=allMobiles.iterator();
        while (iterator.hasNext()){
            Mobile mobile=iterator.next();
            if (mobile.getCost()>500){
                mobilesMoreThan500.add(mobile);
            }
        }

        return mobilesMoreThan500;
    }

    //Iterate through the List created in the first method
    //Return the List of Mobile whose Pixel is more than 12MP
    public List<Mobile> findPhonePixelMoreThan12MP()
    {
        List<Mobile> mobilesMoreThan12MP = new ArrayList<>();
        Iterator<Mobile> iterator= allMobiles.iterator();
        while (iterator.hasNext()){
            Mobile mobile = iterator.next();
            if (mobile.getCameraPixels()>12){
                mobilesMoreThan12MP.add(mobile);
            }
        }

        return mobilesMoreThan12MP;
    }


}

