/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package tamagotchi;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
class AppTest {
	@Test
	void startNewAppElemental() throws IOException, ClassNotFoundException {
		String name = "TESTstartGameelemental";
		System.setIn(new ByteArrayInputStream(("elemental\n"+name+"\n").getBytes()));
		App.startNewGame();
		Pet pet = App.loadGame(name);
		assertEquals(name,pet.name_);
		assertEquals("steak",pet.getFavoriteFood());
	}
	@Test
	void startNewGameDragon() throws IOException, ClassNotFoundException {
		String name = "TESTstartGamedragon";
		System.setIn(new ByteArrayInputStream(("dragon\n" + name + "\n").getBytes()));
		App.startNewGame();
		Pet pet = App.loadGame(name);
		assertEquals(name,pet.name_);
		assertEquals("tuna",pet.getFavoriteFood());
	}

	@Test
	void PlayAppCatFeedNormalFood() throws IOException {
		System.setIn(new ByteArrayInputStream(("feed\napple\nclose\n").getBytes()));
		Pet dragon = new Dragon("PlayGamedragonFeedNormalFood","female");
		App.startGame(dragon);

		assertEquals(10,dragon.hunger_);
		assertEquals(10,dragon.attention_);
		assertEquals(8,dragon.hygiene_);
	}
	@Test
	void PlayAppCatFeedFavoriteFood() throws IOException {
		System.setIn(new ByteArrayInputStream(("feed\ntuna\nclose\n").getBytes()));
		Pet cat = new Dragon("PlayGameDragonFeedFavoriteFood","male");
		App.startGame(cat);

		assertEquals(1,cat.hunger_);
		assertEquals(4,cat.attention_);
		assertEquals(7,cat.hygiene_);
	}
	@Test
	void PlayAppElementalFeedFavoriteFood() throws IOException {
		System.setIn(new ByteArrayInputStream(("feed\nsteak\nclose\n").getBytes()));
		Pet elemental = new Elemental("PlayGameElementalFeedFavoriteFood","male");
		App.startGame(elemental);

		assertEquals(1,elemental.hunger_);
		assertEquals(4,elemental.attention_);
		assertEquals(7,elemental.hygiene_);
	}
	@Test
	void PlayAppCatCleanToilet() throws IOException {
		System.setIn(new ByteArrayInputStream(("clean\ntoilet\nclose\n").getBytes()));
		Pet dragon = new Dragon("PlayGameDragonCleanToilet","male");
		App.startGame(dragon);

		assertEquals(2,dragon.hygiene_);
	}
	@Test
	void PlayAppCatCleanBath() throws IOException {
		System.setIn(new ByteArrayInputStream(("clean\nbath\nclose\n").getBytes()));
		Pet cat = new Dragon("PlayGameDragonCleanBath","male");
		App.startGame(cat);

		assertEquals(2,cat.hygiene_);
	}
	@Test
	void PlayAppCatCleanGrooming() throws IOException {
		System.setIn(new ByteArrayInputStream(("clean\ngrooming\nclose\n").getBytes()));
		Pet cat = new Dragon("PlayGameDragonCleanGrooming","male");
		App.startGame(cat);

		assertEquals(2,cat.hygiene_);
	}
	@Test
	void PlayAppCatCleanBack() throws IOException {
		System.setIn(new ByteArrayInputStream(("clean\nback\nclose\n").getBytes()));
		Pet cat = new Dragon("PlayGameDragonCleanBath","male");
		App.startGame(cat);

		assertEquals(10,cat.hygiene_);
	}
	@Test
	void PlayAppElementalSleepingClose() throws IOException {//TODO how do i do this
		System.setIn(new ByteArrayInputStream(("sleep\nyes\nclose\n").getBytes()));
		Pet elemental = new Elemental("PlayGameElementalSleepingClose","female");
		//App.startApp(elemental);
	}

	@Test
	void PlayAppElementalSleepingWakeUp() throws IOException { // ToDO create sleep function
		System.setIn(new ByteArrayInputStream(("sleep\nyes\nclose\nwake up\nclose\n").getBytes()));
		Pet elemental = new Elemental("PlayGameElementalSleepingWakeUp","male");
		App.startGame(elemental);
		assertEquals(3,elemental.attention_);
		assertEquals(6,elemental.hunger_);
	}
	@Test
	void REVIVE() throws IOException {
		System.setIn(new ByteArrayInputStream(("clean\nbath\nclose\n").getBytes()));
		Pet elemental = new Elemental("Jesus","male");

		elemental.hunger_ = 0;
		elemental.attention_ = 0;
		elemental.hygiene_ = 0;
		elemental.check_death();

		App.startGame(elemental);
		assertEquals(0,elemental.hygiene_);
	}

	@Test
	void readwriteFileTest() throws IOException, ClassNotFoundException {
		//ToDO: setter for fav food
		String name = "readwriteFileTest";
		Pet testelemental = new Elemental(name,"female");
		App.write_file(testelemental);
		Pet pet = App.read_file(name);
		assertEquals(name,pet.name_);
		assertEquals("steak",pet.getFavoriteFood());
	}

	@Test
	void PlayAppElementalSleepingBack() throws IOException {
		System.setIn(new ByteArrayInputStream(("sleep\nyes\nclose\nback\nclose\nwake up\nyes\nclose\n").getBytes()));
		Pet elemental = new Elemental("PlayGameElementalSleepingBack","male");
		//throw new org.opentest4j.AssertionFailedError(" App is in infinite loop. this line can be removed, when problem is resolved");
		App.startGame(elemental); // this statement creates infinite loop
	}
}
/*
class FoodTest {
	@Test
	void TestApple(){
		String name = "apple";
		int energy = 1;
		Apple apple = new Apple();

		assertEquals(name, apple.name);
		assertEquals(energy, apple.energy);
	}
	@Test
	void TestBread(){
		String name = "bread";
		int energy = 3;
		Bread bread = new Bread();

		assertEquals(name, bread.name);
		assertEquals(energy, bread.energy);
	}
	@Test
	void TestSteak(){
		String name = "steak";
		int energy = 4;
		Steak steak = new Steak();

		assertEquals(name, steak.name);
		assertEquals(energy, steak.energy);
	}
	@Test
	void TestTuna(){
		String name = "tuna";
		int energy = 4;
		Tuna tuna = new Tuna();

		assertEquals(name, tuna.name);
		assertEquals(energy, tuna.energy);
	}
}

class TestToy {
	@Test
	void TestBall(){
		String name = "Ball";
		int fun = 3;
		Ball ball = new Ball();

		assertEquals(name, ball.name);
		assertEquals(fun, ball.fun);
	}
	@Test
	void TestStick(){
		String name = "Stick";
		int fun = 1;
		Stick stick = new Stick();

		assertEquals(name, stick.name);
		assertEquals(fun, stick.fun);
	}
	@Test
	void TestYarn(){
		String name = "Yarn";
		int fun = 2;
		Yarn yarn = new Yarn();

		assertEquals(name, yarn.name);
		assertEquals(fun, yarn.fun);
	}
}
*/

class TestPet {
	@Test
	void TestElemental(){
		Elemental elemental = new Elemental("elemental","male");
		assertEquals("elemental", elemental.name_);
		String favfood = elemental.getFavoriteFood();
		String favtoy = elemental.getFavoriteToy();
		assertEquals(favfood, elemental.getFavoriteFood());
		assertEquals(favtoy, elemental.getFavoriteToy());
		assertEquals(10, elemental.hunger_);
		assertEquals(10, elemental.attention_);
		assertEquals(10, elemental.hygiene_);
	}
	@Test
	void TestCat(){
		Dragon cat = new Dragon("cattt","female");
		assertEquals("cattt", cat.name_);
		String favfood = cat.getFavoriteFood();
		String favtoy = cat.getFavoriteToy();
		assertEquals(favfood, cat.getFavoriteFood());
		assertEquals(favtoy, cat.getFavoriteToy());
		assertEquals(10, cat.hunger_);
		assertEquals(10, cat.attention_);
		assertEquals(10, cat.hygiene_);
	}
	@Test
	void TestFeed(){
		Dragon cat = new Dragon("cattt","female");
		cat.set_hunger(5.0f);
		cat.set_hygiene(5.0f);
		cat.set_attention(5.0f);
		String favfood = cat.getFavoriteFood();
		cat.feed(favfood);
		assertEquals(10.0f, cat.hunger_);
		assertEquals(6.0f, cat.attention_); 		//vergleich von pointer und nicht strings in if()
		assertEquals(3.0f, cat.hygiene_);

		for (String food: cat.food){
			if (!food.equals(favfood)){
				favfood=food;
				break;
			}
		}
		cat.set_hunger(5.0f);
		cat.feed(favfood);
		assertEquals(8.0f, cat.hunger_);
		assertEquals(6.0f, cat.attention_);
		assertEquals(1.0f, cat.hygiene_);
	}

	@Test
	void TestClean(){
		Dragon cat = new Dragon("cattt","female");
		cat.set_hunger(5.0f);
		cat.set_hygiene(5.0f);
		cat.set_attention(5.0f);

		cat.clean("");	//why parameter??
		assertEquals(8, cat.hygiene_);
		assertEquals(5, cat.hunger_);
		assertEquals(5, cat.attention_);
	}
	@Test
	void TestPlay(){
		Dragon cat = new Dragon("cattt","female");
		cat.set_hunger(5.0f);
		cat.set_hygiene(5.0f);
		cat.set_attention(5.0f);
		String favtoy = cat.getFavoriteToy();
		cat.play(favtoy);

		assertEquals(10.0f, cat.attention_);
	}
}
class TestTime {
	@Test
	void TestTime(){
		Time time1 = new Time(5, 12, 55);

		assertEquals(5, time1.days_);
		assertEquals(12, time1.hours_);
		assertEquals(55, time1.minutes_);
	}
}