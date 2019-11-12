package cn.programminglife.service.impl;

import cn.programminglife.bean.Shopcart;
import cn.programminglife.dao.ShopcartDao;
import cn.programminglife.service.ShopcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author programmerlc
 * @create 2019-10-15-19:47
 */
@Service
public class ShopcartServiceImpl implements ShopcartService {

    @Autowired
    private ShopcartDao shopcartDao;

    @Override
    public List<Shopcart> findAllShopcartByUid(int user_id) {
        return shopcartDao.findAllShopcartByUid(user_id);
    }

    @Override
    public void addToShopcart(Shopcart shopcart) {
        Shopcart res = shopcartDao.findShopcart(shopcart);
        if(res ==null){
            shopcartDao.addToShopcart(shopcart);
        }else{
            shopcart.setProduct_num(shopcartDao.findProductNumByShopcart(shopcart)+shopcart.getProduct_num());
            shopcartDao.updateShopcart(shopcart);
        }
    }

    @Override
    public void deleteShopcartById(int shopid,int user_id) {
        shopcartDao.deleteShopCartByPid(shopid,user_id);
    }

    @Override
    public void clearShopcartByUid(int user_id) {
        shopcartDao.deleteShopCartByUid(user_id);
    }
}
