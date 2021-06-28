package org.jpgp.tweetsrv.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.jpgp.tweetsrv.TweetsrvApplication;
import org.jpgp.tweetsrv.domain.Hashtags;
import org.jpgp.tweetsrv.repository.HashtagsRepository;
import org.jpgp.tweetsrv.service.impl.HashtagsService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TweetsrvApplication.class)
@ActiveProfiles("test")
class HashtagsServiceTest {

	@Autowired
	HashtagsService service;
	@Autowired
	HashtagsRepository repository;

	private void pushData() {
		repository.deleteAll();

		repository.save(new Hashtags().Hashtag("Elem1").contador(200L));
		repository.save(new Hashtags().Hashtag("Elem2").contador(150L));
		repository.save(new Hashtags().Hashtag("Elem3").contador(125L));
		repository.save(new Hashtags().Hashtag("Elem4").contador(110L));
		repository.save(new Hashtags().Hashtag("Elem5").contador(100L));
		repository.save(new Hashtags().Hashtag("Elem6").contador(90L));
		repository.save(new Hashtags().Hashtag("Elem7").contador(75L));
		repository.save(new Hashtags().Hashtag("Elem8").contador(50L));
		repository.save(new Hashtags().Hashtag("Elem9").contador(1L));
		repository.save(new Hashtags().Hashtag("Elem10").contador(1L));
		repository.save(new Hashtags().Hashtag("Elem11").contador(1L));
		repository.save(new Hashtags().Hashtag("Elem12").contador(1L));
		repository.save(new Hashtags().Hashtag("Elem13").contador(1L));
		repository.save(new Hashtags().Hashtag("Elem14").contador(1L));
		repository.save(new Hashtags().Hashtag("Elem15").contador(1L));
	}

	@Test
	void testGetHashtags_paramVacio() {
		try {
			pushData();

			Optional<Integer> numMax = Optional.empty();
			List<Hashtags> hashtags = service.getHashtags(numMax);

			assertEquals(10, hashtags.size());
			assertEquals(200L, hashtags.get(0).getContador());
			assertEquals(150L, hashtags.get(1).getContador());
			assertEquals(125L, hashtags.get(2).getContador());
			assertEquals(110L, hashtags.get(3).getContador());
			assertEquals(100L, hashtags.get(4).getContador());
		} catch (Throwable t) {
			fail("Excepcion:" + t.toString());
		}
	}

	@Test
	void testGetHashtags_paramCambiado() {
		try {
			pushData();

			Optional<Integer> numMax = Optional.of(5);
			List<Hashtags> hashtags = service.getHashtags(numMax);

			assertEquals(5, hashtags.size());
			assertEquals(200L, hashtags.get(0).getContador());
			assertEquals(150L, hashtags.get(1).getContador());
			assertEquals(125L, hashtags.get(2).getContador());
			assertEquals(110L, hashtags.get(3).getContador());
			assertEquals(100L, hashtags.get(4).getContador());
		} catch (Throwable t) {
			fail("Excepcion:" + t.toString());
		}
	}

}
