package user.model;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import de.alpharogroup.user.entities.ResetPasswords;
import de.alpharogroup.user.repositories.ResetPasswordsDao;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class ResetPasswordsDaoTest extends AbstractTestNGSpringContextTests {
	@Autowired
	private ResetPasswordsDao resetPasswordsDao;



	@Test(enabled=false)
	public void testFindAll() {
		final List<ResetPasswords> all = resetPasswordsDao.findAll();
		System.out.println(all);
	}
}