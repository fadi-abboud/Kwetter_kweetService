package Kwetterkweetservice;

import Kwetterkweetservice.KweetModels.ModelsReturn.ReturnModelGetKweetsFrom;
import Kwetterkweetservice.dataAccessLayer.repo.RepositoryKweet;
import Kwetterkweetservice.KweetModels.Kweet;
import Kwetterkweetservice.KweetModels.ModelsReturn.ReturnModelSendKweet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration(loader= AnnotationConfigContextLoader.class)
class KweetserviceApplicationTests {


    @Configuration
    static class ContextConfiguration {
        @Bean
        public RepositoryKweet repositoryKweet() {
            RepositoryKweet repositoryKweet = new RepositoryKweet(true);

            return repositoryKweet;
        }
    }
    @Autowired
    private RepositoryKweet repositoryKweet;

    @Test
    void testGetTweetsFromUser() {
        ReturnModelGetKweetsFrom returnModel = repositoryKweet.getKweetsFromUser(0);

        Kweet expected = new Kweet();

        expected.setKweet_id(0);
        expected.setUser_id(0);
        expected.setDate("01-06-2022");
        expected.setLikes(5);
        expected.setMessage("that is a test kweet");

        Kweet actual = returnModel.getKweets().get(0);

        assertThat(actual)
                .isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    void testSendKweet() {
        ReturnModelSendKweet returnModel = repositoryKweet.sendKweet(0, "that is a test kweet");

        boolean expected = true;

        boolean actual = returnModel.isSuccess();

        assertEquals(expected, actual);
    }

    @Test
    void testDeleteKweet() {
        ReturnModelSendKweet returnModel = repositoryKweet.deleteKweet(0);

        boolean expected = true;

        boolean actual = returnModel.isSuccess();

        assertEquals(expected, actual);
    }
}
