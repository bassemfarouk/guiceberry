package tutorial_1_server;

import com.google.inject.Inject;
import com.google.inject.testing.guiceberry.GuiceBerryEnv;
import com.google.inject.testing.guiceberry.controllable.InjectionController;
import com.google.inject.testing.guiceberry.junit3.GuiceBerryJunit3TestCase;

import tutorial_1_server.prod.PetOfTheMonth;

@GuiceBerryEnv(Tutorial1Envs.PET_STORE_ENV_4_CANONICAL_SAME_JVM_CONTROLLABLE_POTM)
public class Example4CanonicalSameJvmControllableInjectionTest extends GuiceBerryJunit3TestCase {

  @Inject
  WelcomeTestPage welcomeTestPage;
  
  @Inject
  private InjectionController injectionController;

  // TODO: tests are failing -- fix the Env to actually rewrite the bindings.
  
  public void testDogAsPotm() {
    PetOfTheMonth expected = PetOfTheMonth.DOG;
    injectionController.substitute(PetOfTheMonth.class, expected);
    welcomeTestPage.goTo();
    welcomeTestPage.assertPetOfTheMonth(expected);
  }

  public void testCatAsPotm() {
    PetOfTheMonth expected = PetOfTheMonth.CAT;
  injectionController.substitute(PetOfTheMonth.class, expected);
  welcomeTestPage.goTo();
  welcomeTestPage.assertPetOfTheMonth(expected);
  }
}