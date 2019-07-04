package com.qwer.util;

public class SuccessRateUtil {

    private static final Integer phoneFare[] = {20,30,50,100,200};


    // 随机范围的金额
    /*
     * role:
        <option value="10" >任意金额</option>
        <option value="99" >不能整百支付</option>
        <option value="100" >整百支付</option>
        <option value="500" >话费面额</option>
        <option value="1000" >固定金额</option>
     * */
    public static String getOrderMoneyByRange(Integer max,Integer min,String amountList,Integer role){
        Integer random = (int)(Math.random()*(max-min)+min);
        String result = "";
        switch (role){
            case 10:
                random = (random/10)*10;
                break;
            case 99:
                if(random%100 == 0){
                    random += 10;
                    if(random > max){
                        random = max-50;
                    }
                }
                break;
            case 100:
                random = (random/100)*100;
                break;
            case 500:
                random = getOrderMoneyByArray(phoneFare);
                break;
            case 1000:
                if(amountList == null || amountList.equals("")){
                    throw new NullPointerException("固定金额列表为空");
                }
                String[] split = amountList.split(",");
                if(split.length == 0){
                    throw new IllegalStateException("金额请用英文符号隔开");
                }

                random = Integer.parseInt(getOrderMoneyByArray(split));
                break;
            default:
                break;
        }
        return random + result;
    }

    // 随机获得数组中的内容
    public static Integer getOrderMoneyByArray(Integer[] arr){
        int l = arr.length-1;
        int m = (int) (Math.random() * l);
        return arr[m];
    }
    // 随机获得数组中的内容
    public static String getOrderMoneyByArray(String[] arr){
        int l = arr.length-1;
        int m = (int) (Math.random() * l);
        return arr[m];
    }
}
