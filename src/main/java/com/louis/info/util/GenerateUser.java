package com.louis.info.util;

import com.louis.info.pojo.User;

import org.apache.commons.dbutils.QueryRunner;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
 * 赖小燚
 * www.louis.com
 */
public class GenerateUser {

    private static List<String> first_names = new ArrayList<>();   //姓氏集
    private static int first_names_size;    //姓氏集长度
    private static List<String> boy_last_names = new ArrayList<>();    //男生名字集
    private static int boy_last_names_size; //男生名字集长度
    private static List<String> girl_last_names = new ArrayList<>();   //女生名字集
    private static int girl_last_names_size; //女生名字集长度
    private static List<String> provinceList = new ArrayList<>();  //省份集
    private static int provinceListSize;    //省份集长度
    private static Map<String,List<String>> addressMap = new HashMap<>();    //地址集
    private static int addressMapSize;  //地址集长度
    private static String[] educationList = {"小学","初中","高中","大专","大学","研究生","博士","博士后"};
    private static String[] healthList = {"健康","良好","患重病"};
    private static Long[] phoneList = {
            13179006810L,
            13283123821L,
            17605609116L,
            15983586154L,
            18258741778L,
            15807087002L,
            13905698865L,
            17730229487L,
            15168177074L,
            10691425354L,       //10
            18296707609L,
            15655126208L,
            15970161502L,
            18756937136L,
            17730226018L,
            13506818333L,
            18810968505L,
            17165683256L,
            19965131320L,
            16565990246L
    };
    private static int id = 20211221;

    private String name;    //名字
    private String sex; //性别
    private String address; //地址
    private int height;  //身高
    private int weight;  //体重
    private String education;   //教育
    private String health;  //健康
    private int roleId = 1;
    private String phonenumber;   //手机号
    private String email;   //邮箱

    public void setPhonenumber() {
        Random random = new Random();
        int index = random.nextInt(20);
        phonenumber = phoneList[index].toString();
        email = phonenumber+"@qq.com";
        phoneList[index]++;
    }

    public void setEducation() {
        Random random = new Random();
        int probability = random.nextInt(100);
        if(probability>=0 && probability<=60){
            education = educationList[random.nextInt(3)];
        }else if(probability >60 && probability<=80){
            education = educationList[3+random.nextInt(2)];
        }else{
            education = educationList[5+random.nextInt(3)];
        }
    }

    public void setHealth() {
        Random random = new Random();
        int probability = random.nextInt(100);
        if(probability>=0 && probability<=85){
            health = healthList[random.nextInt(2)];
        }else{
            health = healthList[2];
        }
    }

    public void setHeight() {
        Random random = new Random();
        int probability = random.nextInt(100);
        if(probability>=0 && probability<=10){
            //身高在140-160
            height = 140+random.nextInt(20);
        }else if(probability>10 && probability<=90){
            //身高在160-180
            height = 160+random.nextInt(20);
        }else {
            height = 180+random.nextInt(20);
        }
    }

    public void setWeight(){
        Random random = new Random();
        int probability = random.nextInt(100);
        if(sex == "女"){
            if(probability>=0 && probability<=70){
                //女生体重在90-110
                weight = 90 + random.nextInt(20);
            }else if(probability>70 && probability<=95) {
                weight = 110+random.nextInt(40);
            }else {
                weight = 150+random.nextInt(40);
            }
        }
        if(sex == "男"){
            if(probability>=0 && probability<=25){
                //女生体重在90-110
                weight = 90 + random.nextInt(20);
            }else if(probability>25 && probability<=75) {
                weight = 110+random.nextInt(40);
            }else {
                weight = 150+random.nextInt(40);
            }
        }
    }

    public void setAddress() {
        Random random = new Random();
        StringBuffer temp = new StringBuffer();
        String province = provinceList.get(random.nextInt(provinceListSize));
        temp.append(province);
        int citySize = addressMap.get(province).size();
        temp.append(addressMap.get(province).get(random.nextInt(citySize)));
        address = temp.toString();
    }

    static {
        setFirst_names();
        setBoy_last_names();
        setGirl_last_names();
        setAddressMap();
    }

    //创建用户之前的准备工作
    private void prepare(){
        setSex();
        setName();
        setEducation();
        setPhonenumber();
        setAddress();
        setHeight();
        setWeight();
    }

    private User create(){
        User user = new User();
        user.setId(Integer.toString(id));
        id++;
        user.setGender(sex);   //性别
        user.setUsername(name);
        user.setPassword("123456");
        user.setAddress(address);
        user.setHeight(height); //身高
        user.setWeight(weight); //体重
        user.setEducation(education);
        user.setPhoneNumber(phonenumber);
        user.setEmail(email);
        System.out.println(user);
        return user;
    }

    public void setSex() {
        Random random = new Random();
        if(random.nextInt(2)==1){
            sex =  "男";
        }else {
            sex =  "女";
        }
    }

    public void setName() {
        Random random = new Random();
        StringBuffer temp = new StringBuffer();
        temp.append(first_names.get(random.nextInt(first_names_size)));
        if(sex == "男"){
            temp.append(boy_last_names.get(random.nextInt(boy_last_names_size)));
        }
        if(sex == "女"){
            temp.append(girl_last_names.get(random.nextInt(boy_last_names_size)));
        }
        name = temp.toString();
        System.out.println(name);
    }

    public static void setFirst_names() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Codes\\JavaCode\\InfoManager\\src\\main\\java\\com\\louis\\info\\util\\first-name.txt")));
            String line;
            while((line=reader.readLine())!=null){
                if(line.length()!=0){
                    String[] temp = line.split("    ");
                    for(String name : temp){
                        first_names.add(name);
                    }
                }
            }
            first_names_size = first_names.size();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void setBoy_last_names() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Codes\\JavaCode\\InfoManager\\src\\main\\java\\com\\louis\\info\\util\\boy_last_name.txt")));
            String line = null;
            while((line=reader.readLine())!=null){
                String[] temp = line.split("   ");
                for(String name : temp){
                    boy_last_names.add(name);
                }
            }
            boy_last_names_size = boy_last_names.size();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setGirl_last_names() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Codes\\JavaCode\\InfoManager\\src\\main\\java\\com\\louis\\info\\util\\girl_last_name.txt")));
            String line = null;
            while((line=reader.readLine())!=null){
                String[] temp = line.split("   ");
                for(String name : temp){
                    girl_last_names.add(name);
                }
            }
            girl_last_names_size = girl_last_names.size();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setAddressMap() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Codes\\JavaCode\\InfoManager\\src\\main\\java\\com\\louis\\info\\util\\address.txt")));
            String line = null;
            while ((line=reader.readLine())!=null){
                String[] temp = line.split(" ");
                String province = temp[0];  //省份
                provinceList.add(province);
                List<String> cities = new ArrayList<>();
                for(String city : temp){
                    if(!city.contains("省")){
                        cities.add(city);
                    }
                }
                addressMap.put(province,cities);
            }
            provinceListSize = provinceList.size();
            addressMapSize = addressMap.size();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GenerateUser user = new GenerateUser();
        QueryRunner runner = new QueryRunner();
        Connection connection = JDBCUtils.getConnection();
        int iid = 20211221;
        try{
            for(int i = 0;i < 200000; i++){
                user.prepare();
                String sql = "insert into user_table(id,username,pwd,gender,education,phonenumber,address,email,height,weight) values(?,?,?,?,?,?,?,?,?,?)";
                runner.update(connection,sql,iid,user.name,"123456",user.sex,user.education,user.phonenumber,user.address,user.email,user.height,user.weight);
                user.create();
                iid++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
