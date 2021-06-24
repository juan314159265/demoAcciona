
package com.sine95.tweetsrv.repository;



import java.util.*;
import com.sine95.tweetsrv.domain.Tweets;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.sine95.kernel.base.repository.RepositoryBase;




/**
 * Spring Data  repository for the Tweets entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TweetsRepository extends RepositoryBase< Tweets,Long > {


//Si hay que a�adir m�todos se incluyen aqu�, se recomienda utilizar este tipo de comentario para no interferir con el DELETE


/*


*/
}
