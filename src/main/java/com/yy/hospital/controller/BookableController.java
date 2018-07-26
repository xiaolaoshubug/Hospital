package com.yy.hospital.controller;

import com.yy.hospital.Service.BookableService;
import com.yy.hospital.Service.DoctorsService;
import com.yy.hospital.domain.Bookable;
import com.yy.hospital.domain.Doctors;
import com.yy.hospital.domain.WeekBean;
import com.yy.hospital.domain.WeekBookable;
import com.yy.hospital.mapper.DoctorsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api")
public class BookableController {

    @Autowired
    private BookableService bookableService;
    @Autowired
    private DoctorsMapper doctorsMapper;

    @RequestMapping(value = "bookabledepartdoctor" , method = RequestMethod.POST)
    public ResponseEntity<?> findBookableByBdateAdDoid(@RequestParam("datetime")Date bdate , @RequestParam("deid")Integer deid){
        WeekBookable weekBookable = new WeekBookable();
        Map<String,List<Bookable>> map = new HashMap<>();
        List<Bookable> bookableList = new ArrayList<>();

        // 1.从bookable中获取列表信息
        bookableList = bookableService.findBookableByBdateAdDoid(bdate,deid);


        // 2.把统计信息导入到WeekBean类中
        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
        // 看有多少个医生，把每个医生的doid存入set中(因为bookableList中一个医生有多条数据，所以为了不重复用set)
        for(int i=0;i<bookableList.size();i++){
            set.add(bookableList.get(i).getDoid());
        }
        // 有少个医生，建多少个weekBean,并setDoid
        WeekBean[] weekBeanArrays = new WeekBean[set.size()];
        Iterator it = set.iterator();
        int n = 0;
        while(it.hasNext()){
            weekBeanArrays[n] = new WeekBean();
            weekBeanArrays[n].setDoid((Integer) it.next());
            n++;
        }
        n=0;

        // weekBean中setDoname和setAreg
        // setDoname
        weekBeanArrays[n].setDoname(doctorsMapper.findByDoid(bookableList.get(0).getDoid()).getDoname());
        for(int j=0;j<bookableList.size();j++){
            // 因为一个weekBean对应多个bookableList,所以当bookableList中的doid变了，weekBean才跟着变
            if(!weekBeanArrays[n].getDoid().equals(bookableList.get(j).getDoid())){
                n++;
                weekBeanArrays[n].setDoname(doctorsMapper.findByDoid(bookableList.get(j).getDoid()).getDoname());
            }


            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E");
            String e = simpleDateFormat.format(bookableList.get(j).getBdate());
            System.out.println(e);
            if(e.equals("星期一")){
                if(bookableList.get(j).getStarttime()==0){
                    weekBeanArrays[n].setAreg1("值班坐诊");
                }else{
                    weekBeanArrays[n].setPreg1("值班坐诊");
                }
                System.out.println(weekBeanArrays[n].getAreg1()+","+weekBeanArrays[n].getPreg1());
            }else if(e.equals("星期二")){
                if(bookableList.get(j).getStarttime()==0){
                    weekBeanArrays[n].setAreg2("值班坐诊");
                }else{
                    weekBeanArrays[n].setPreg2("值班坐诊");
                }
            }else if(e.equals("星期三")){
                if(bookableList.get(j).getStarttime()==0){
                    weekBeanArrays[n].setAreg3("值班坐诊");
                }else{
                    weekBeanArrays[n].setPreg3("值班坐诊");
                }
            }else if(e.equals("星期四")){
                if(bookableList.get(j).getStarttime()==0){
                    weekBeanArrays[n].setAreg4("值班坐诊");
                }else{
                    weekBeanArrays[n].setPreg4("值班坐诊");
                }
            }else if(e.equals("星期五")){
                if(bookableList.get(j).getStarttime()==0){
                    weekBeanArrays[n].setAreg5("值班坐诊");
                }else{
                    weekBeanArrays[n].setPreg5("值班坐诊");
                }
            }else if(e.equals("星期六")){
                if(bookableList.get(j).getStarttime()==0){
                    weekBeanArrays[n].setAreg6("值班坐诊");
                }else{
                    weekBeanArrays[n].setPreg6("值班坐诊");
                }
            }else if(e.equals("星期天")){
                if(bookableList.get(j).getStarttime()==0){
                    weekBeanArrays[n].setAreg7("值班坐诊");
                }else{
                    weekBeanArrays[n].setPreg7("值班坐诊");
                }
            }

        }
        //把weekBean数组的对象放但weeBean列表中(因为返回的参数是WeekBookable，WeekBookable里面的属性都是list)
        List<WeekBean> weekBeanList = new ArrayList<>();
        for(int h=0 ; h<weekBeanArrays.length;h++){
            weekBeanList.add(weekBeanArrays[h]);
        }




        // 3.星期列表
        List<String> weekList = new ArrayList<>();
        weekList.add("星期一");
        weekList.add("星期二");
        weekList.add("星期三");
        weekList.add("星期四");
        weekList.add("星期五");
        weekList.add("星期六");
        weekList.add("星期日");


        // 4 .将weekList和weekBeanList装入weekBookable(result)
        weekBookable.setWeekList(weekList);
        weekBookable.setWeekBeanList(weekBeanList);



        return new ResponseEntity<WeekBookable>(weekBookable,HttpStatus.OK);
    }


    // 查询本星期是否排班
    @RequestMapping(value = "/bookablealldoctor" , method = RequestMethod.POST)
    public ResponseEntity<?> autoBK(@RequestParam("datetime")Date bdate , @RequestParam("deid")Integer deid){
        int result = 0;
        if(bookableService.findBookableByBdateAdDoid(bdate,deid).size()>0){
            result = 1;
        }
        Map<String,Integer> map = new HashMap<>();
        map.put("result",result);
        return new ResponseEntity<Map<String,Integer>>(map,HttpStatus.OK);
    }

    @RequestMapping(value="/bookableadd" , method = RequestMethod.POST)
    public ResponseEntity<?> autoBK02(@RequestParam("datetime")Date bdate , @RequestParam("deid")Integer deid){
        //先拿到上一个星期的排班信息
        List<Bookable> list = bookableService.findLastBookable(bdate , deid);
        //插入到新的排班表
        for(int n = 0 ; n< list.size() ; n++){
            //used的默认值应该为0
            int result = bookableService.insertNewBookable(list.get(n).getDoid(),list.get(n).getBdate(),list.get(n).getStarttime(),
                                                1,list.get(n).getBnum(),list.get(n).getXcum());

        }
        return  new ResponseEntity<String>("ok" , HttpStatus.OK);
    }
}
