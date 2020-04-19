//package com.book.mall.thread.test;
//
//import com.ninebot.apr.robotcube.beans.dto.SortDTO;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Sort;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class SortToolsTest {
//
//    @Resource
//    private AreaStationRepository areaStationRepository;
//
//
//    @Test
//    public void basicSort() {
//        System.out.println(SortTools.basicSort());
//
//    }
//
//    @Test
//    public void testBasicSort() throws NoSuchFieldException {
//        Sort sort = SortTools.basicSort("asc", AreaStationModel.class.getDeclaredField("stationOrder").getName());
//        List<AreaStationModel> modelList = areaStationRepository.findAllByAreaId("0c596bad53c846a48289f4d8f767ffaa", sort);
//
//        assert modelList.get(0).getStationOrder() < modelList.get(1).getStationOrder();
//        System.out.println(modelList);
//    }
//
//    @Test
//    public void testBasicSort1() throws NoSuchFieldException {
//
//        Sort sort = SortTools.basicSort("asc", AreaStationModel.class.getDeclaredField("stationOrder").getName());
//        List<AreaStationModel> modelList = areaStationRepository.findAllByAreaId("0c596bad53c846a48289f4d8f767ffaa", SortTools.basicSort(new SortDTO("asc", "stationOrder"), new SortDTO("desc", "id")));
//
//        assert modelList.get(0).getStationOrder() < modelList.get(1).getStationOrder();
//        System.out.println(modelList);
//    }
//}
