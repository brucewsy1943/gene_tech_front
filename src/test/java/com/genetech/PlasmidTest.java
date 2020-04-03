package com.genetech;

import com.genetech.bean.dto.PageDto;
import com.genetech.bean.dto.PlasmidInfoDto;
import com.genetech.service.PlasmidService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2019/12/24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlasmidTest {

    @Autowired
    private PlasmidService plasmidService;

    @Test
    public void testPlasmid() throws NoSuchMethodException {
        plasmidService.getFilterConditions();
    }

    @Test
    public void testPlasmidService(){
        String[] plasmid_type_array = new String[]{"1","2","3"};
        String[] growth_bacterial_resistance_array = new String[]{"1","2","3"};
        String[] gene_species_array = new String[]{"1","2","3"};
        String[] plasmid_description_array = new String[]{"1","2","3"};

        PlasmidInfoDto plasmidInfoDto = new PlasmidInfoDto();
      /*  plasmidInfoDto.setGene_species_array(gene_species_array);
        plasmidInfoDto.setPlasmid_type_array(plasmid_type_array);
        plasmidInfoDto.setGrowth_bacterial_resistance_array(growth_bacterial_resistance_array);
        plasmidInfoDto.setPlasmid_description_array(plasmid_description_array);*/
        plasmidInfoDto.setPlasmid_type("1,2,3");
        plasmidInfoDto.setGrowth_bacterial_resistance("4,5,6");
        plasmidInfoDto.setGene_species("1,2,3");
        plasmidInfoDto.setPlasmid_description("1,2,3");

        plasmidInfoDto.setKeyword("123");

        plasmidInfoDto.setColumn_value1("553634");
        plasmidInfoDto.setColumn_name1("plasmid_type");


        PageDto pageDto = new PageDto();
        plasmidService.getPlasmidInfoPage(plasmidInfoDto,pageDto);
    }

}
