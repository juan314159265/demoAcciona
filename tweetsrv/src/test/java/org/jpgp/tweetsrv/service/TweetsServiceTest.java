package org.jpgp.tweetsrv.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.jpgp.tweetsrv.TweetsrvApplication;
import org.jpgp.tweetsrv.domain.Tweet;
import org.jpgp.tweetsrv.repository.TweetRepository;
import org.jpgp.tweetsrv.service.impl.TweetsService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TweetsrvApplication.class)
@ActiveProfiles("test")
class TweetsServiceTest {

	@Autowired
	TweetsService service;

	@Autowired
	TweetRepository repository;

	@Test
	void testGetTweets_ListaVacia() {
		try {
			repository.deleteAll();

			List<Tweet> tweets = service.getTweets();

			assertEquals(0, tweets.size());
		} catch (Throwable t) {
			fail("Excepcion:" + t.toString());
		}
	}

	@Test
	void testGetTweets_Lista1() {
		try {
			repository.deleteAll();
			repository.save(new Tweet().usuario("pepe").texto("HolaMundo").localizacionLatidud("10.25")
					.localizacionLongitud("10.25").validacion(false));

			List<Tweet> tweets = service.getTweets();

			assertEquals(1, tweets.size());
			assertEquals("pepe", tweets.get(0).getUsuario());
			assertEquals("HolaMundo", tweets.get(0).getTexto());
		} catch (Throwable t) {
			fail("Excepcion:" + t.toString());
		}

	}

	@Test
	void testGetTweets_Lista5() {
		try {
			repository.deleteAll();
			for (int i = 0; i < 5; i++) {
				repository.save(new Tweet().usuario("pepe" + i).texto("HolaMundo" + i).validacion(false));
			}

			List<Tweet> tweets = service.getTweets();

			assertEquals(5, tweets.size());
			for (int i = 0; i < 5; i++) {
				assertEquals("pepe" + i, tweets.get(i).getUsuario());
				assertEquals("HolaMundo" + i, tweets.get(i).getTexto());
			}
		} catch (Throwable t) {
			fail("Excepcion:" + t.toString());
		}
	}

	@Test
	void testValidate() {
		try {
			repository.deleteAll();
			Tweet save = repository.save(new Tweet().usuario("pepe").texto("HolaMundo").localizacionLatidud("10.25")
					.localizacionLongitud("10.25").validacion(false));

			Tweet validate = service.validate(save.getId());

			assertEquals(true, validate.getValidacion());
		} catch (Throwable t) {
			fail("Excepcion:" + t.toString());
		}
	}

	@Test
	void testGetTweetsValidates() {
		try {
			repository.deleteAll();
			Tweet save = repository.save(new Tweet().usuario("pepe").texto("HolaMundo").localizacionLatidud("10.25")
					.localizacionLongitud("10.25").validacion(false));

			Tweet validate = service.validate(save.getId());

			List<Tweet> tweetsValidates = service.getTweetsValidates();

			assertEquals(1, tweetsValidates.size());
			assertEquals(validate.getId(), tweetsValidates.get(0).getId());
			assertEquals(validate.getUsuario(), tweetsValidates.get(0).getUsuario());
			assertEquals(validate.getTexto(), tweetsValidates.get(0).getTexto());
		} catch (Throwable t) {
			fail("Excepcion:" + t.toString());
		}
	}

}
