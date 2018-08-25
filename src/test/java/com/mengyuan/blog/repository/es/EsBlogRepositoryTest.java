package com.mengyuan.blog.repository.es;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.mengyuan.blog.domain.es.EsBlog;
import com.mengyuan.blog.repository.EsBlogRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTest {
    
    @Autowired
    private EsBlogRepository esBlogRepository;
    
    @Before
    public void initRepositoryData(){
        // clean all data
        esBlogRepository.deleteAll();
        
        esBlogRepository.save(new EsBlog("A1", "B1", "C1"));
        esBlogRepository.save(new EsBlog("A2", "B2", "D2"));
        esBlogRepository.save(new EsBlog("A2", "F2", "E3"));
    }
    
    @Test
    public void testfindDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(){
        
        Pageable pageable = new PageRequest(0, 20);
        
        String title = "A2";
        String summary = "C1";
        String content = "F2";
        
        Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(
                title, summary, content, pageable);
        
        assertThat(page.getTotalElements()).isEqualTo(2);
        
        for(EsBlog esBlog : page.getContent()){
            System.out.println(esBlog.toString());
        }
    }
}
