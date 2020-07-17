//package com.lambdaschool.zoos;
//
//import com.github.javafaker.Faker;
//import com.github.javafaker.service.FakeValuesService;
//import com.github.javafaker.service.RandomService;
//import com.lambdaschool.zoos.models.Animal;
//import com.lambdaschool.zoos.models.Telephone;
//import com.lambdaschool.zoos.models.Zoo;
//import com.lambdaschool.zoos.services.AnimalService;
//import com.lambdaschool.zoos.services.ZooService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Locale;
//
///**
// * SeedData puts both known and random data into the database. It implements CommandLineRunner.
// * <p>
// * CoomandLineRunner: Spring Boot automatically runs the run method once and only once
// * after the application context has been loaded.
// */
//@Transactional
////@Component
//public class SeedData
//        implements CommandLineRunner
//{
//    /**
//     * Connects the Animal Service to this process
//     */
//    @Autowired
//    AnimalService animalService;
//
//    /**
//     * Connects the zoo service to this process
//     */
//    @Autowired
//    ZooService zooService;
//
//
//    /**
//     * Generates test, seed data for our application
//     * First a set of known data is seeded into our database.
//     * Second a random set of data using Java Faker is seeded into our database.
//     * Note this process does not remove data from the database. So if data exists in the database
//     * prior to running this process, that data remains in the database.
//     *
//     * @param args The parameter is required by the parent interface but is not used in this process.
//     */
//    @Transactional
//    @Override
//    public void run(String[] args) throws
//            Exception
//    {
//        zooService.deleteAll();
//        animalService.deleteAll();
//        Animal r1 = new Animal("admin");
//        Animal r2 = new Animal("zoo");
//        Animal r3 = new Animal("data");
//
//        r1 = animalService.save(r1);
//        r2 = animalService.save(r2);
//        r3 = animalService.save(r3);
//
//        // admin, data, zoo
//        Zoo u1 = new Zoo("admin",
//                           "password",
//                           "admin@lambdaschool.local");
//        u1.getTelephones()
//                .add(new Telephone(u1,
//                                   "admin@email.local"));
//        u1.getTelephones()
//                .add(new Telephone(u1,
//                                   "admin@mymail.local"));
//        u1.getAnimals()
//                .add(r1);
//        u1.getAnimals()
//                .add(r2);
//        u1.getAnimals()
//                .add(r3);
//        zooService.save(u1);
//
//        // data, zoo
//        Zoo u2 = new Zoo("cinnamon",
//                           "1234567",
//                           "cinnamon@lambdaschool.local");
//        u2.getTelephones()
//                .add(new Telephone(u2,
//                                   "cinnamon@mymail.local"));
//        u2.getTelephones()
//                .add(new Telephone(u2,
//                                   "hops@mymail.local"));
//        u2.getTelephones()
//                .add(new Telephone(u2,
//                                   "bunny@email.local"));
//        u2.getAnimals()
//                .add(r2);
//        u2.getAnimals()
//                .add(r3);
//        zooService.save(u2);
//
//        Zoo u3 = new Zoo("barnbarn",
//                           "ILuvM4th!",
//                           "barnbarn@lambdaschool.local");
//        u3.getTelephones()
//                .add(new Telephone(u3,
//                                   "barnbarn@email.local"));
//        u3.getAnimals()
//                .add(r2);
//        zooService.save(u3);
//
//        Zoo u4 = new Zoo("puttat",
//                           "password",
//                           "puttat@school.lambda");
//        u4.getAnimals()
//                .add(r2);
//        zooService.save(u4);
//
//        Zoo u5 = new Zoo("misskitty",
//                           "password",
//                           "misskitty@school.lambda");
//        u5.getAnimals()
//                .add(r2);
//        zooService.save(u5);
//
//        if (false)
//        {
//            // using JavaFaker create a bunch of regular zoos
//            FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-US"),
//                                                                        new RandomService());
//            Faker nameFaker = new Faker(new Locale("en-US"));
//
//            for (int i = 0; i < 25; i++)
//            {
//                new Zoo();
//                Zoo fakeZoo;
//
//                fakeZoo = new Zoo(nameFaker.name()
//                                            .username(),
//                                    "password",
//                                    nameFaker.internet()
//                                            .emailAddress());
//
//                // generating random gmail email acounts
//                fakeZoo.getTelephones()
//                        .add(new Telephone(fakeZoo,
//                                           fakeValuesService.bothify("????##@gmail.com")));
//                fakeZoo.getAnimals()
//                        .add(r2);
//                zooService.save(fakeZoo);
//            }
//        }
//    }
//}