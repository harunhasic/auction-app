package com.atlantbh.auction.seeder;

import com.atlantbh.auction.model.*;
import com.atlantbh.auction.repository.*;
import com.sun.istack.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.logging.Level;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Order(1)
public class DataSeeder implements CommandLineRunner {

    private static final Logger LOGGER = Logger.getLogger(DataSeeder.class);

    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Product> listOfProducts = new ArrayList<>();
        List<Category> setOfCategories = new ArrayList<>();
        List<Address> listOfAddresses = new ArrayList<>();
        List<User> listOfUsers = new ArrayList<>();
        List<SubCategory> setOfSubcategories = new ArrayList<>();


        Category fashion = new Category("Fashion");
        Category accessories = new Category("Accessories");
        Category jewelery = new Category("Jewelery");
        Category shoes = new Category("Shoes");
        Category sportware = new Category("Sportware");
        Category home = new Category("Home");
        Category electronics = new Category("Electronics");
        Category mobile = new Category("Mobile");
        Category computer = new Category("Computer");
        Category tools = new Category("Tools");
        Category books = new Category("Books");

        setOfCategories.add(fashion);
        setOfCategories.add(accessories);
        setOfCategories.add(jewelery);
        setOfCategories.add(shoes);
        setOfCategories.add(sportware);
        setOfCategories.add(home);
        setOfCategories.add(electronics);
        setOfCategories.add(mobile);
        setOfCategories.add(computer);
        setOfCategories.add(tools);
        setOfCategories.add(books);

        categoryRepository.saveAll(setOfCategories);

        SubCategory wedding = new SubCategory("Wedding", fashion);
        wedding.setPhotoUrl("https://i.insider.com/5f32f8e83ad86149ec464bc3?width=1100&format=jpeg&auto=webp");
        SubCategory womanClothes = new SubCategory("Woman clothes", fashion);
        womanClothes.setPhotoUrl("https://images.unsplash.com/photo-1512436991641-6745cdb1723f?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjEyMDd9");
        SubCategory coats = new SubCategory("Coats", fashion);
        coats.setPhotoUrl("https://ae01.alicdn.com/kf/HTB1VizEXcrrK1RjSspaq6AREXXaI/Coats-Man-Winter-2018-Korean-Mens-Double-Breasted-Jacket-Coat-Slim-Fit-Wool-Trench-Coat-Men.jpg_q50.jpg");
        SubCategory vintage = new SubCategory("Vintage", fashion);
        vintage.setPhotoUrl("https://sammydvintage.com/wp-content/uploads/2012/10/40s-clothes-pussycat-blouses.jpg");
        SubCategory manClothes = new SubCategory("Man Clothes", fashion);
        manClothes.setPhotoUrl("https://i.pinimg.com/originals/13/ec/0a/13ec0a8cedb648a8d547261808032dad.jpg");
        SubCategory winterClothes = new SubCategory("Winter clothes", fashion);
        winterClothes.setPhotoUrl("https://images-na.ssl-images-amazon.com/images/I/611I4RQj1zL._AC_UX385_.jpg");
        SubCategory watches = new SubCategory("Watches", accessories);
        watches.setPhotoUrl("https://preview.redd.it/zfegrkerlk031.jpg?width=960&crop=smart&auto=webp&s=77f929c834026b75567d63acce85c65e611765d2");
        SubCategory sunglassesSub = new SubCategory("Sunglasses", accessories);
        sunglassesSub.setPhotoUrl("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/sunglasses-copy-1596831360.jpg");
        SubCategory swimmingGlasses = new SubCategory("Swimming glasses", accessories);
        swimmingGlasses.setPhotoUrl("https://image.made-in-china.com/2f0j00zQkfVoZhVWga/Big-Frame-Swimming-Goggles-Swim-Glasses-with-Customized-Logo.jpg");
        SubCategory masks = new SubCategory("Masks", accessories);
        masks.setPhotoUrl("https://www.siliconewristbandsdirect.co.uk/wp-content/uploads/2018/08/Embossed-Silicone-Wristband-4.png");
        SubCategory hatsSubCategory = new SubCategory("Hats", accessories);
        hatsSubCategory.setPhotoUrl("https://media.gq.com/photos/5a04f9a398002d2e253679f5/master/pass/fall-hatsSubCategory-gq-style-0816-01-1.jpg");
        SubCategory bags = new SubCategory("Bags", accessories);
        bags.setPhotoUrl("https://shotkit.com/wp-content/uploads/2017/09/Best-camera-bags-in-2018.jpg");
        SubCategory necklaces = new SubCategory("Necklaces", jewelery);
        necklaces.setPhotoUrl("https://marianilsdotter.com/wp-content/uploads/2020/05/categorypage-necklaces-mobile.jpg");
        SubCategory weddingRings = new SubCategory("Engagement rings", jewelery);
        weddingRings.setPhotoUrl("https://www.tacori.com/media/gene-cms/e/n/engagementring-foundersring_d.jpg");
        SubCategory rings = new SubCategory("Rings", jewelery);
        rings.setPhotoUrl("https://cdn.caratlane.com/media/catalog/product/cache/6/image/480x480/9df78eab33525d08d6e5fb8d27136e95//J/R/JR03980-YGP900_11_listfront.jpg");
        SubCategory charms = new SubCategory("Charms", jewelery);
        charms.setPhotoUrl("https://images-na.ssl-images-amazon.com/images/I/61R4RPG-6VL._SL1024_.jpg");
        SubCategory bracelet = new SubCategory("Bracelet", jewelery);
        bracelet.setPhotoUrl("https://stewartdawsons-co-nz.imgix.net/category/0908598001568258595~1568258596.jpg?w=1310&h=655&fit=crop&auto=format&q=60&s=0982a63914f9191b7e31b455ab6bf243");
        SubCategory bodyPierceing = new SubCategory("Body piercing", jewelery);
        bodyPierceing.setPhotoUrl("https://cdn.shopify.com/s/files/1/2065/1597/articles/body-piercing-jewelry-pierced-mississauga_287_874106b3-4b77-4bbd-ac58-97e4cf1b3a60_1200x630.jpg?v=1594148533");
        SubCategory sneakers = new SubCategory("Sneakers", shoes);
        sneakers.setPhotoUrl("https://images-na.ssl-images-amazon.com/images/I/61QFvgXbH9L._UL1200_.jpg");
        SubCategory runningShoesSub = new SubCategory("Running shoes", shoes);
        runningShoesSub.setPhotoUrl("https://www.saucony.com/on/demandware.static/-/Sites-saucony_us-Library/default/dwb7a76b30/content/seasonal-content/homepage/2020/10/home-main-trending-20201001-prinkshop-mens-d.jpg");
        SubCategory heels = new SubCategory("Heels", shoes);
        heels.setPhotoUrl("https://www.switchbacktravel.com/sites/default/files/image_fields/Best%20Of%20Gear%20Articles/Hiking%20and%20Backpacking/Hiking%20Shoes/Salomon%20X%20Ultra%203%20GTX%20Low%20hiking%20shoe.jpg");
        SubCategory winterShoes = new SubCategory("Winter shoes", shoes);
        winterShoes.setPhotoUrl("https://cdn.myshoptet.com/usr/www.loap.eu/user/shop/big/20120-3_loap-primosa-women-s-winter-shoes-beige-brown-hsl19205c03r.jpg?5f067b28");
        SubCategory classyShoes = new SubCategory("Classy shoes", shoes);
        classyShoes.setPhotoUrl("https://i.pinimg.com/originals/7b/19/ec/7b19ec1c85423013362cbc4ff580cc0f.jpg");
        SubCategory summerShoes = new SubCategory("Summer shoes", shoes);
        summerShoes.setPhotoUrl("https://footwearnews.com/wp-content/uploads/2018/04/castaner-summer-shoes-blue-background.jpg?w=1024");
        SubCategory resistanceBands = new SubCategory("Resistance Bands", sportware);
        resistanceBands.setPhotoUrl("https://www.wigglestatic.com/product-media/104069067/adidas-Must-Have-BOS-Short-Shorts-Black-White-SS20-DX7662S-8.jpg?w=430&h=430&a=7");
        SubCategory menTraining = new SubCategory("Mens training clothes", sportware);
        menTraining.setPhotoUrl("https://ae01.alicdn.com/kf/H9ee1ae499a3441bea2f3c3295c79da97f/Running-Training-Clothes-Men-7PCS-SETS-Compression-Running-Sets-Basketball-Jogging-Tights-Underwear-Set-Gym-Fitness.jpg_960x960.jpg");
        SubCategory tankTops = new SubCategory("Tank tops", sportware);
        tankTops.setPhotoUrl("https://ae01.alicdn.com/kf/Ha9be6321825c44e49ecc67434ddab799u.jpg?smt_ispass_5508316");
        SubCategory gymAccessories = new SubCategory("Gym accessories", sportware);
        gymAccessories.setPhotoUrl("https://images-na.ssl-images-amazon.com/images/I/71F4QaVtFHL.jpg");
        SubCategory womanTraining = new SubCategory("Women training clothes", sportware);
        womanTraining.setPhotoUrl("https://ae01.alicdn.com/kf/H6ddd5bcea89c4071812deea49b4e9ec39/Women-Yoga-Sets-Five-piece-5-Set-Female-Clothing-Sets-Gym-Clothes-for-Women-Sportswear-Sports.jpg");
        SubCategory headgear = new SubCategory("Headgear", sportware);
        headgear.setPhotoUrl("https://i.pinimg.com/originals/73/d4/17/73d417f127910a9e10e7f76822eae207.jpg");
        SubCategory bathroom = new SubCategory("Bathroom", home);
        bathroom.setPhotoUrl("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/colorful-bathrooms-heidi-caillier-design-seattle-interior-designer-bathroom-pink-zellige-tile-scaled-1584654087.jpg");
        SubCategory bedroom = new SubCategory("Bedroom", home);
        bedroom.setPhotoUrl("https://www.yankodesign.com/images/design_news/2020/06/bedroom-designs/07-bedroom-Designs_Natural-Lighting_Berlin-HOuse.jpg");
        SubCategory kitchen = new SubCategory("Kitchen", home);
        kitchen.setPhotoUrl("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/kitchen-ideas-hbx100119inspoindex-029-1572548599.jpg");
        SubCategory livingRoom = new SubCategory("Living room", home);
        livingRoom.setPhotoUrl("https://images.unsplash.com/photo-1583847268964-b28dc8f51f92?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
        SubCategory kidsRoom = new SubCategory("Kids room", home);
        kidsRoom.setPhotoUrl("https://media.architecturaldigest.com/photos/574f51cc1cd9644b0beb1e6a/master/pass/KinderModern-high-design-kids-room_02.jpg");
        SubCategory balcony = new SubCategory("Balcony", home);
        balcony.setPhotoUrl("https://cdn.decoist.com/wp-content/uploads/2019/09/Dash-of-timeless-NYC-charm-for-the-tiny-balcony-next-to-the-bedroom.jpg");
        SubCategory kitchenElectronics = new SubCategory("Kitchen electronics", electronics);
        kitchenElectronics.setPhotoUrl("https://mydecorative.com/wp-content/uploads/2019/05/new-refrigerator.jpg");
        SubCategory tvs = new SubCategory("TVs", electronics);
        tvs.setPhotoUrl("https://iqmobile.ba/wp-content/uploads/2019/10/32incha.png");
        SubCategory lamps = new SubCategory("Lamps", electronics);
        lamps.setPhotoUrl("https://assets.pbimgs.com/pbimgs/ab/images/dp/wcm/202021/0028/faris-ceramic-table-lamp-base-c.jpg");
        SubCategory gamingConsole = new SubCategory("Gaming consoles", electronics);
        gamingConsole.setPhotoUrl("https://miro.medium.com/max/3696/0*UqnTgDYpNqtEJrsC.jpg");
        SubCategory washingMachines = new SubCategory("Washing machines", electronics);
        washingMachines.setPhotoUrl("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/gh-best-washing-machines-1589999096.png");
        SubCategory conditioning = new SubCategory("Air conditioning", electronics);
        conditioning.setPhotoUrl("https://merculexenergy.com/wp-content/uploads/2020/05/smart-ac.jpg");
        SubCategory phones = new SubCategory("Phones", mobile);
        phones.setPhotoUrl("https://cdn.pocket-lint.com/r/s/1200x/assets/images/120309-phones-buyer-s-guide-best-smartphones-2020-the-top-mobile-phones-available-to-buy-today-image1-eagx1ykift.jpg");
        SubCategory chargers = new SubCategory("Chargers", mobile);
        chargers.setPhotoUrl("https://cdn.shopify.com/s/files/1/0107/9030/5892/products/Samsung-2-1A-Wall-Charger-SDL472017473-1-6d413_62646787-703d-4ea6-b686-e158d0042da5_838x.jpeg?v=1588158546");
        SubCategory headphones = new SubCategory("Headphones", mobile);
        headphones.setPhotoUrl("https://images.unsplash.com/photo-1505740420928-5e560c06d30e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
        SubCategory memoryCards = new SubCategory("Memory cards", mobile);
        memoryCards.setPhotoUrl("https://upload.wikimedia.org/wikipedia/commons/0/0b/Memory-card-comparison.jpg");
        SubCategory cases = new SubCategory("Cases", mobile);
        cases.setPhotoUrl("https://images-na.ssl-images-amazon.com/images/I/61rMFuu5sFL._SL1500_.jpg");
        SubCategory screenProtectors = new SubCategory("Screen protectors", mobile);
        screenProtectors.setPhotoUrl("https://cdnblob.moshi.com/uploadedfiles/photo/v3/productImages/1065/01.jpg");
        SubCategory laptops = new SubCategory("Laptops", computer);
        laptops.setPhotoUrl("https://cdn.mos.cms.futurecdn.net/X5TyA8uvkGXoNyjFzxcowS.jpg");
        SubCategory gamingComputers = new SubCategory("Gaming computers", computer);
        gamingComputers.setPhotoUrl("https://media.wired.com/photos/5ed56dac0164ade5f2950d7f/master/pass/Gear-Buying-Guide-HP-Omen-Desktop-SOURCE-HP.jpg");
        SubCategory officeComputers = new SubCategory("Office computers", computer);
        officeComputers.setPhotoUrl("https://i.pcmag.com/imagery/reviews/04xTDKsqdUzgKvWI7MGVnG3-1..1598204639.jpg");
        SubCategory hardware = new SubCategory("Hardware", computer);
        hardware.setPhotoUrl("https://cdn.wccftech.com/wp-content/uploads/2020/06/NVIDIA-RTX-3080-3D-Feature-2.jpg");
        SubCategory software = new SubCategory("Software", computer);
        software.setPhotoUrl("https://chiefexecutive.net/wp-content/uploads/2018/11/AdobeStock_92323963-compressor-1024x662.jpeg");
        SubCategory monitors = new SubCategory("Monitors", computer);
        monitors.setPhotoUrl("https://9to5mac.com/wp-content/uploads/sites/6/2019/05/LG-UltraFine-4K-Display-Review-9to5mac.jpg?quality=82&strip=all&w=1600");
        SubCategory drills = new SubCategory("Drills", tools);
        drills.setPhotoUrl("https://media.4rgos.it/i/Argos/8260385_R_Z001A?w=750&h=440&qlt=70");
        SubCategory wrenches = new SubCategory("Wrenches", tools);
        wrenches.setPhotoUrl("https://img.lovepik.com/photo/50007/8945.jpg_wh860.jpg");
        SubCategory measuringTapes = new SubCategory("Measuring tapes", tools);
        measuringTapes.setPhotoUrl("https://5.imimg.com/data5/DX/IO/MY-17043459/fiber-glass-measuring-tapes-500x500.jpg");
        SubCategory handTools = new SubCategory("Hand tools", tools);
        handTools.setPhotoUrl("https://cdn1.vectorstock.com/i/1000x1000/89/80/modern-hand-tools-instruments-collection-vector-2148980.jpg");
        SubCategory knives = new SubCategory("Knives", tools);
        knives.setPhotoUrl("https://cdn1.fnsharp.com/wp-content/uploads/2019/08/types-of-kitchen-knives.jpeg");
        SubCategory screwdrivers = new SubCategory("Screwdrivers", tools);
        screwdrivers.setPhotoUrl("https://s3-production.bobvila.com/articles/wp-content/uploads/2017/04/Types_Of_Screwdrivers.jpg");
        SubCategory childrenBooks = new SubCategory("Children books", books);
        childrenBooks.setPhotoUrl("https://images-na.ssl-images-amazon.com/images/I/71IRyc2IB0L.jpg");
        SubCategory motivationalBooks = new SubCategory("Motivational books", books);
        motivationalBooks.setPhotoUrl("https://thestrive.co/wp-content/uploads/2019/03/Best-Motivational-Books.png");
        SubCategory scifiBooks = new SubCategory("SCIFI books", books);
        scifiBooks.setPhotoUrl("https://media.wired.com/photos/5be4cd03db23f3775e466767/125:94/w_2375,h_1786,c_limit/books-521812297.jpg");
        SubCategory romanceBooks = new SubCategory("Romance books", books);
        romanceBooks.setPhotoUrl("https://media.glamour.com/photos/5d31c84e613e440008564e91/master/w_1661,h_2560,c_limit/04-books.jpg");
        SubCategory cookBooks = new SubCategory("Cook books", books);
        cookBooks.setPhotoUrl("https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimg1.cookinglight.timeinc.net%2Fsites%2Fdefault%2Ffiles%2Fstyles%2Fmedium_2x%2Fpublic%2Fupdated_main_images%2F1111p131-best-general-cookbooks-x.jpg%3Fitok%3Dbk-t2871");
        SubCategory diyBooks = new SubCategory("DIY Books", books);
        diyBooks.setPhotoUrl("https://images-na.ssl-images-amazon.com/images/I/81SUyqPkpTL.jpg");

        setOfSubcategories.add(wedding);
        setOfSubcategories.add(womanClothes);
        setOfSubcategories.add(bathroom);
        setOfSubcategories.add(winterClothes);
        setOfSubcategories.add(sneakers);
        setOfSubcategories.add(phones);
        setOfSubcategories.add(laptops);
        setOfSubcategories.add(watches);
        setOfSubcategories.add(watches);
        setOfSubcategories.add(necklaces);
        setOfSubcategories.add(weddingRings);
        setOfSubcategories.add(runningShoesSub);
        setOfSubcategories.add(coats);
        setOfSubcategories.add(vintage);
        setOfSubcategories.add(manClothes);
        setOfSubcategories.add(sunglassesSub);
        setOfSubcategories.add(swimmingGlasses);
        setOfSubcategories.add(masks);
        setOfSubcategories.add(hatsSubCategory);
        setOfSubcategories.add(bags);
        setOfSubcategories.add(resistanceBands);
        setOfSubcategories.add(rings);
        setOfSubcategories.add(charms);
        setOfSubcategories.add(bracelet);
        setOfSubcategories.add(bodyPierceing);
        setOfSubcategories.add(heels);
        setOfSubcategories.add(winterShoes);
        setOfSubcategories.add(classyShoes);
        setOfSubcategories.add(summerShoes);
        setOfSubcategories.add(menTraining);
        setOfSubcategories.add(tankTops);
        setOfSubcategories.add(gymAccessories);
        setOfSubcategories.add(womanTraining);
        setOfSubcategories.add(headgear);
        setOfSubcategories.add(bedroom);
        setOfSubcategories.add(kitchen);
        setOfSubcategories.add(livingRoom);
        setOfSubcategories.add(kidsRoom);
        setOfSubcategories.add(balcony);
        setOfSubcategories.add(kitchenElectronics);
        setOfSubcategories.add(tvs);
        setOfSubcategories.add(lamps);
        setOfSubcategories.add(gamingConsole);
        setOfSubcategories.add(washingMachines);
        setOfSubcategories.add(conditioning);
        setOfSubcategories.add(chargers);
        setOfSubcategories.add(headphones);
        setOfSubcategories.add(memoryCards);
        setOfSubcategories.add(cases);
        setOfSubcategories.add(screenProtectors);
        setOfSubcategories.add(gamingComputers);
        setOfSubcategories.add(officeComputers);
        setOfSubcategories.add(hardware);
        setOfSubcategories.add(software);
        setOfSubcategories.add(monitors);
        setOfSubcategories.add(drills);
        setOfSubcategories.add(wrenches);
        setOfSubcategories.add(measuringTapes);
        setOfSubcategories.add(handTools);
        setOfSubcategories.add(knives);
        setOfSubcategories.add(screwdrivers);
        setOfSubcategories.add(childrenBooks);
        setOfSubcategories.add(motivationalBooks);
        setOfSubcategories.add(scifiBooks);
        setOfSubcategories.add(romanceBooks);
        setOfSubcategories.add(cookBooks);
        setOfSubcategories.add(diyBooks);

        if (subCategoryRepository.findByName(wedding.getName()) == null) {
            subCategoryRepository.saveAll(setOfSubcategories);
        } else LOGGER.log(Level.WARNING, "Subcategories are already seeded");

        listOfAddresses.add(new Address("Vojvodica Put 3 ", "Zenica", "Bosnia & Herzegovina", "65262"));
        listOfAddresses.add(new Address("246 E Colden Ave", "Los Angeles", "US", "90003"));
        listOfAddresses.add(new Address("1648 W Ontario St", "Chicago", "US", "60622"));
        listOfAddresses.add(new Address("88 Station Road ", "London", "UK", "WC2N 5DU"));
        if (addressRepository.findByStreet(listOfAddresses.get(0).getStreet()) == null) {
            addressRepository.saveAll(listOfAddresses);
        } else LOGGER.log(Level.WARNING, "Addresses are already seeded");


        listOfUsers.add(new User("Harun", "Hasic", "harunze@hotmail.com", "male", new Date("24/02/1998"), "062-679-679", new BCryptPasswordEncoder().encode("Harun123"), "/assets/images/profile1.jpg"));
        listOfUsers.add(new User("Tommy", "Jameson", "tommy@hotmail.com", "male", new Date("05/03/1985"), "062-123-456", new BCryptPasswordEncoder().encode("Tommy123"), "/assets/images/profile2.jpg"));
        listOfUsers.add(new User("Tom", "Hanks", "demo@tom.com", "male", new Date("05/02/1965"), "432-321-2345", new BCryptPasswordEncoder().encode("Tommy123"), "/assets/images/profile3.png"));
        listOfUsers.add(new User("Alice", "Hopkins", "kleopatra@demo.com", "female", new Date("22/02/1927"), "123-456-1231", new BCryptPasswordEncoder().encode("Tommy123"), "/assets/images/profile4.jpg"));
        listOfUsers.get(0).setAddress(listOfAddresses.get(0));
        listOfUsers.get(0).setProfilePhotoUrl("https://w7.pngwing.com/pngs/340/946/png-transparent-avatar-user-computer-icons-software-developer-avatar-child-face-heroes.png");
        listOfUsers.get(1).setAddress(listOfAddresses.get(1));
        listOfUsers.get(1).setProfilePhotoUrl("https://png.pngtree.com/element_our/20190604/ourmid/pngtree-user-avatar-boy-image_1482937.jpg");
        listOfUsers.get(2).setAddress(listOfAddresses.get(2));
        listOfUsers.get(2).setProfilePhotoUrl("https://cdn1.vectorstock.com/i/1000x1000/31/95/user-sign-icon-person-symbol-human-avatar-vector-12693195.jpg");
        listOfUsers.get(3).setAddress(listOfAddresses.get(3));
        if (userRepository.findByFirstName(listOfUsers.get(0).getFirstName()) == null) {
            userRepository.saveAll(listOfUsers);
        } else LOGGER.log(Level.WARNING, "Users are already seeded.");

        Set<Photo> runningShoes = Stream.of(
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/puma/thumbs_800/374011-01_800_800px.jpg", true),
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/puma/thumbs_800/374011-01_1_800_800px.jpg", true),
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/puma/thumbs_800/374011-01_3_800_800px.jpg", true),
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/puma/thumbs_800/374011-01_4_800_800px.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> runningShoes2 = Stream.of(
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/nike/thumbs_800/CJ0611-100_800_800px.jpg", true),
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/nike/thumbs_800/CJ0611-100_1_800_800px.jpg", true),
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/nike/thumbs_800/CJ0611-100_2_800_800px.jpg", true),
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/nike/thumbs_800/CJ0611-100_4_800_800px.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> runningShoes3 = Stream.of(
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/adidas/thumbs_800/FX8834_800_800px.jpg", true),
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/adidas/thumbs_800/FX8834_1_800_800px.jpg", true),
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/adidas/thumbs_800/FX8834_3_800_800px.jpg", true),
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/adidas/thumbs_800/FX8834_4_800_800px.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> runningShoes4 = Stream.of(
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/no-name-brand/thumbs_800/3022590-600_800_800px.jpg", true),
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/no-name-brand/thumbs_800/3022590-600_1_800_800px.jpg", true),
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/no-name-brand/thumbs_800/3022590-600_2_800_800px.jpg", true),
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/no-name-brand/thumbs_800/3022590-600_4_800_800px.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> iPhone11Pro = Stream.of(
                new Photo("https://www.univerzalno.com/wp-content/uploads/2019/10/iPhone11ProMAX8.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2019/10/iPhone11ProMAX7.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2019/10/iPhone11ProMAX9.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2019/10/iPhone11ProMAX12.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> iPhoneX = Stream.of(
                new Photo("https://www.univerzalno.com/wp-content/uploads/2019/06/apple_iphone_x_64gb10.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2019/06/apple_iphone_x_64gb3.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2019/06/apple_iphone_x_64gb4.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2019/06/apple_iphone_x_64gb5.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> iPhoneXr = Stream.of(
                new Photo("https://www.univerzalno.com/wp-content/uploads/2019/02/apple_iphone_xr_128gb_30907883201-1.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2019/02/apple_iphone_xr_128gb_30907883202-1.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2019/02/apple_iphone_xr_128gb_30907883203-1.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2019/02/apple_iphone_xr_128gb_30907883204-1.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> s20 = Stream.of(
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/03/samsungs20-1.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/03/samsungs20-2.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/03/samsungs20-5.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/03/samsungs20-4.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> hpG7 = Stream.of(
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/09/hp450-1.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/09/hp450-2.jpg", true),
                new Photo("https://teranews.net/wp-content/uploads/2019/09/noutbuk-hp-250-g7-4.jpg", true),
                new Photo("https://media.karousell.com/media/photos/products/2020/7/31/hp_probook_440_g7_i5_1596172518_fa03034b_progressive", true)
        ).collect(Collectors.toSet());
        Set<Photo> macbookPro = Stream.of(
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/08/macbooki9-9880H-1.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/08/macbooki9-9880H-2.jpg", true),
                new Photo("https://m.media-amazon.com/images/S/aplus-media/sota/d8afcb2e-7f37-4767-8611-136b3d25fb2e.__CR0,0,970,600_PT0_SX970_V1___.jpg", true),
                new Photo("https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6421/6421409_sd.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> lenovo = Stream.of(
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/10/111.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/10/2.png", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/10/5.png", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/10/6.png", true)
        ).collect(Collectors.toSet());
        Set<Photo> dell = Stream.of(
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/04/1-17.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/04/2-17.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/04/5-1.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/04/6-1.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> bunkbed = Stream.of(
                new Photo("https://cdn2.jysk.com/getimage/wd2.large/98995", true),
                new Photo("https://cdn2.jysk.com/getimage/wd2.large/98996", true),
                new Photo("https://cdn2.jysk.com/getimage/wd2.large/98997", true),
                new Photo("https://cdn1.jysk.com/getimage/wd2.large/26751", true)
        ).collect(Collectors.toSet());
        Set<Photo> kingsize = Stream.of(
                new Photo("https://cdn2.jysk.com/getimage/wd2.large/72282", true),
                new Photo("https://cdn2.jysk.com/getimage/wd2.large/73576", true),
                new Photo("https://cdn2.jysk.com/getimage/wd2.large/90538", true),
                new Photo("https://cdn2.jysk.com/getimage/wd2.large/89935", true)
        ).collect(Collectors.toSet());
        Set<Photo> bed = Stream.of(
                new Photo("https://cdn3.jysk.com/getimage/wd2.large/123942", true),
                new Photo("https://cdn3.jysk.com/getimage/wd2.large/99020", true),
                new Photo("https://cdn3.jysk.com/getimage/wd2.large/123943", true),
                new Photo("https://cdn3.jysk.com/getimage/wd2.large/123944", true)
        ).collect(Collectors.toSet());
        Set<Photo> cover = Stream.of(
                new Photo("https://cdn4.jysk.com/getimage/wd2.medium/107527", true),
                new Photo("https://cdn4.jysk.com/getimage/wd2.medium/103803", true),
                new Photo("https://media.sheridan.com.au/catalog/product/S/3/S3Y5_B113_C226-531_silver_1_1700x1700.jpg", true),
                new Photo("https://secure.img1-fg.wfcdn.com/im/91949996/resize-h800-w800%5Ecompr-r85/4331/43310952/Vester+Reversible+Down+Alternative+Comforter+Set.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> tissot = Stream.of(
                new Photo("https://d1rkccsb0jf1bk.cloudfront.net/products/99998437/main/large/t106_417_11_051_00-1460379836-2948.jpg", true),
                new Photo("https://d1rkccsb0jf1bk.cloudfront.net/products/99998437/additional/large/99998437-2.jpg", true),
                new Photo("https://d1rkccsb0jf1bk.cloudfront.net/products/99998437/additional/large/99998437-1.jpg", true),
                new Photo("https://d1rkccsb0jf1bk.cloudfront.net/products/99998437/main/large/t106_417_11_051_00-1460379836-2948.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> rolex = Stream.of(
                new Photo("https://i.insider.com/5f4fbfb97ed0ee001e25d021?width=700&format=jpeg&auto=webp", true),
                new Photo("https://i.insider.com/5f4fbfc1e6ff30001d4e6a13?width=700&format=jpeg&auto=webp", true),
                new Photo("https://i.insider.com/5f4fbfc4e6ff30001d4e6a14?width=700&format=jpeg&auto=webp", true),
                new Photo("https://www.watchtradingco.com/wp-content/uploads/2020/05/WTC_Rolex-Submariner-Date_116610LN_face.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> tagheuer = Stream.of(
                new Photo("https://wfmedia.azureedge.net/imgv2/stock/167670/TagHeuer-Carrera-CV2A10.BA0796-167670-2-200911-154653.jpg;quality=95;w=2000", true),
                new Photo("https://wfmedia.azureedge.net/imgv2/stock/167670/TagHeuer-Carrera-CV2A10.BA0796-167670-3-200911-154656.jpg;quality=90;w=800", true),
                new Photo("https://wfmedia.azureedge.net/imgv2/stock/167670/TagHeuer-Carrera-CV2A10.BA0796-167670-4-200911-154707.jpg;quality=90;w=800", true),
                new Photo("https://wfmedia.azureedge.net/imgv2/stock/167670/TagHeuer-Carrera-CV2A10.BA0796-167670-5-200911-154755.jpg;quality=90;w=800", true)
        ).collect(Collectors.toSet());
        Set<Photo> omega = Stream.of(
                new Photo("https://wfmedia.azureedge.net/imgv2/stock/167930/Omega-SpeedmasterMoonwatch-311.32.40.30.01.001-167930-1-200828-134105.jpg;quality=95;w=2000", true),
                new Photo("https://wfmedia.azureedge.net/imgv2/stock/167930/Omega-SpeedmasterMoonwatch-311.32.40.30.01.001-167930-2-200828-134108.jpg;quality=90;w=800", true),
                new Photo("https://wfmedia.azureedge.net/imgv2/stock/167930/Omega-SpeedmasterMoonwatch-311.32.40.30.01.001-167930-3-200828-134112.jpg;quality=90;w=800", true),
                new Photo("https://wfmedia.azureedge.net/images/watchfinderimages/media/IT/wf-box-packaging-2020-02-10-09-06-39-517.jpg;quality=90;w=800", true)
        ).collect(Collectors.toSet());
        Set<Photo> goldenNecklace = Stream.of(
                new Photo("https://i.etsystatic.com/21488876/r/il/df1f1c/2110565155/il_1140xN.2110565155_cbdw.jpg", true),
                new Photo("https://i.etsystatic.com/21488876/r/il/621df1/2536027837/il_1140xN.2536027837_7cbq.jpg", true),
                new Photo("https://i.etsystatic.com/21488876/r/il/fd8adb/2536021463/il_1140xN.2536021463_5mhi.jpg", true),
                new Photo("https://i.etsystatic.com/21488876/r/il/a4cacc/2536025727/il_1140xN.2536025727_eqg7.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> goldenPendant = Stream.of(
                new Photo("https://i.etsystatic.com/19744162/r/il/b101e4/2590387684/il_1140xN.2590387684_ljv0.jpg", true),
                new Photo("https://i.etsystatic.com/19744162/r/il/0e7a5a/2638057505/il_1140xN.2638057505_6zqt.jpg", true),
                new Photo("https://i.etsystatic.com/19744162/r/il/04bbb9/2638057641/il_1140xN.2638057641_hwf4.jpg", true),
                new Photo("https://i.etsystatic.com/19744162/r/il/d829ce/2590383636/il_1140xN.2590383636_jlzf.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> diamondVine = Stream.of(
                new Photo("https://i.etsystatic.com/14106075/r/il/64b904/2411738160/il_1140xN.2411738160_k3g6.jpg", true),
                new Photo("https://i.etsystatic.com/14106075/r/il/0ec4e5/1677888872/il_1140xN.1677888872_2zeh.jpg", true),
                new Photo("https://i.etsystatic.com/14106075/r/il/a47b79/1677906552/il_1140xN.1677906552_nt4j.jpg", true),
                new Photo("https://i.etsystatic.com/14106075/r/il/bd9a58/1725361931/il_1140xN.1725361931_2rbt.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> rosePendant = Stream.of(
                new Photo("https://cdn.shopify.com/s/files/1/0604/4529/products/Rose-Gold-Lotus-LB-1_4000x.progressive.jpg?v=1587546221", true),
                new Photo("https://cdn.shopify.com/s/files/1/0604/4529/products/Rose-Gold-Lotus-LB-2_4000x.progressive.jpg?v=1587546263", true),
                new Photo("https://cdn.shopify.com/s/files/1/0604/4529/products/WEBSITE_Lotus-Little-Buddha-Necklace_4000x.progressive.jpg?v=1589343015", true),
                new Photo("https://cdn.shopify.com/s/files/1/0604/4529/products/WEBSITE_Packaging_b2e9822c-6ee6-4d4f-ba14-2d38c9d1f727_4000x.progressive.jpg?v=1589343024", true)
        ).collect(Collectors.toSet());
        Set<Photo> womansTracksuit = Stream.of(
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/DV2428_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/DV2428_1_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/DV2428_2_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/DV2428_3_600_600px.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> mensTracksuit = Stream.of(
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/FT9183_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/FT9183_1_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/FT9183_2_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/FT9183_3_600_600px.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> womenYoga = Stream.of(
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/GH8508_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/GH8508_1_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/GH8508_2_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/GH8508_3_600_600px.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> menShorts = Stream.of(
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/FS9809_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/FS9809_1_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/FS9809_2_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/FS9809_3_600_600px.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> builtInOven = Stream.of(
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/09/1-34-600x600.png", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/09/2-33-600x600.png", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/09/3-32-600x600.png", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/09/4-27-600x600.png", true)
        ).collect(Collectors.toSet());
        Set<Photo> microwave = Stream.of(
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/04/BryUHuLdcBW-600x600.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/04/M-TehnoMag-10122018-27-1-510Wx510H.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/09/2-14-600x600.png", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/09/3-13-600x600.png", true)
        ).collect(Collectors.toSet());
        Set<Photo> washingMachine = Stream.of(
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/09/1-9.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/09/2-9.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/09/3-9.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/09/4-6.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> dishwasher = Stream.of(
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/09/1-29.png", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/09/2-28-600x600.png", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/09/3-27-600x600.png", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/09/4-22-600x600.png", true)
        ).collect(Collectors.toSet());
        Set<Photo> suit = Stream.of(
                new Photo("https://cdn.laredoute.com/products/680by680/e/c/3/ec364c782c675119db76ff329451f685.jpg", true),
                new Photo("https://cdn.laredoute.com/products/680by680/4/8/6/48602cc569c95065be989ec3de44f715.jpg", true),
                new Photo("https://cdn.laredoute.com/products/72by72/a/6/3/a639ff931ef7ccb2f890362133d84788.jpg", true),
                new Photo("https://cdn.laredoute.com/products/72by72/6/a/d/6adec2301e7f6c5317a1ce3db7c6dd1a.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> dress = Stream.of(
                new Photo("https://cdn.laredoute.com/products/680by680/6/0/0/600657af954a33bc5c4017d382c25e92.jpg", true),
                new Photo("https://cdn.laredoute.com/products/680by680/3/6/6/3668f92978a0da102b563ab6f0eb5816.jpg", true),
                new Photo("https://cdn.laredoute.com/products/680by680/4/7/d/47d095e4067c4418202a25d12eb34402.jpg", true),
                new Photo("https://cdn.laredoute.com/products/680by680/4/c/5/4c54164bbcdc7969dd20155b64064c4a.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> hats = Stream.of(
                new Photo("https://cdn.laredoute.com/products/680by680/f/9/e/f9ea7e207d6201caacbeb20019c02713.jpg", true),
                new Photo("https://cdn.laredoute.com/products/680by680/b/c/d/bcdc719ad621965ca1c1fcea466ef167.jpg", true),
                new Photo("https://cdn.laredoute.com/products/680by680/b/5/3/b53d6bda40c0d3b8cadfdc3413597cdd.jpg", true),
                new Photo("https://cdn.laredoute.com/products/680by680/5/1/7/517449afd38fa7a194585be2d7f57b78.jpg", true)

        ).collect(Collectors.toSet());
        Set<Photo> sunglasses = Stream.of(
                new Photo("https://www.inoma.ba/pub/media/catalog/product/cache/image/e9c3970ab036de70892d86c6d221abfe/R/B/RB_3545_186_9A_54_4.jpg", true),
                new Photo("https://www.inoma.ba/pub/media/catalog/product/cache/image/e9c3970ab036de70892d86c6d221abfe/R/B/RB_3016_125651_51_4.jpg", true),
                new Photo("https://www.inoma.ba/pub/media/catalog/product/cache/image/e9c3970ab036de70892d86c6d221abfe/R/B/RB_3663_002_31_60.jpg", true),
                new Photo("https://www.inoma.ba/pub/media/catalog/product/cache/image/e9c3970ab036de70892d86c6d221abfe/R/B/RB_3025_001_51_62_4.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> hammer = Stream.of(
                new Photo("https://images-na.ssl-images-amazon.com/images/I/61izuKD%2BojL._AC_SL1500_.jpg", true),
                new Photo("https://images-na.ssl-images-amazon.com/images/I/71xWkIrxJNL._AC_SL1500_.jpg", true),
                new Photo("https://images-na.ssl-images-amazon.com/images/I/61zNQ699h5L._AC_SL1500_.jpg", true),
                new Photo("https://images-na.ssl-images-amazon.com/images/I/61j-LAQe3SL._AC_SL1500_.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> cutter = Stream.of(
                new Photo("https://images-na.ssl-images-amazon.com/images/I/61HD2J7E4vL._AC_SL1500_.jpg", true),
                new Photo("https://images-na.ssl-images-amazon.com/images/I/812lXqR3fhL._AC_SL1500_.jpg", true),
                new Photo("https://images-na.ssl-images-amazon.com/images/I/81xYs5fDe1L._AC_SL1500_.jpg", true),
                new Photo("https://images-na.ssl-images-amazon.com/images/I/71Yhj7a4bTL._AC_SL1500_.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> axe = Stream.of(
                new Photo("https://images-na.ssl-images-amazon.com/images/I/61r7oYAcKpL._AC_SL1500_.jpg", true),
                new Photo("https://images-na.ssl-images-amazon.com/images/I/713yYBaDudL._AC_SL1500_.jpg", true),
                new Photo("https://images-na.ssl-images-amazon.com/images/I/71srgifPvpL._AC_SL1500_.jpg", true),
                new Photo("https://images-na.ssl-images-amazon.com/images/I/71qkqzfxfQL._AC_SL1500_.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> saw = Stream.of(
                new Photo("https://media.screwfix.com/is/image//ae235?src=ae235/4114F_P&$prodImageLarge$", true),
                new Photo("https://media.screwfix.com/is/image//ae235?src=ae235/4114F_A1&$prodImageLarge$", true),
                new Photo("https://media.screwfix.com/is/image//ae235?src=ae235/4114F_A2&$prodImageLarge$", true),
                new Photo("https://media.screwfix.com/is/image//ae235?src=ae235/4114F_A4&$prodImageLarge$", true)
        ).collect(Collectors.toSet());
        Set<Photo> harryPotter = Stream.of(
                new Photo("https://images-na.ssl-images-amazon.com/images/I/A1jGvzIZ7ZL.jpg", true),
                new Photo("https://images-na.ssl-images-amazon.com/images/I/91XkoFQSiFL.jpg", true),
                new Photo("https://images-na.ssl-images-amazon.com/images/I/41FHillSXYL.jpg", true),
                new Photo("https://images-na.ssl-images-amazon.com/images/I/41FHillSXYL.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> theGodfather = Stream.of(
                new Photo("https://images-na.ssl-images-amazon.com/images/I/81IHPwG1tbL.jpg", true),
                new Photo("https://images-na.ssl-images-amazon.com/images/I/41LhlqzNVWL.jpg", true),
                new Photo("https://images-na.ssl-images-amazon.com/images/I/31sFGTEmtiL.jpg", true),
                new Photo("https://images-na.ssl-images-amazon.com/images/I/31sFGTEmtiL.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> lotr = Stream.of(
                new Photo("https://images-na.ssl-images-amazon.com/images/I/8134AkhQJgL.jpg", true),
                new Photo("https://images-na.ssl-images-amazon.com/images/I/81+pnufsEsL.jpg", true),
                new Photo("https://images-na.ssl-images-amazon.com/images/I/31HfU7ZE9YL.jpg", true),
                new Photo("https://images-na.ssl-images-amazon.com/images/I/31HfU7ZE9YL.jpg", true)
        ).collect(Collectors.toSet());
        Set<Photo> hyperion = Stream.of(
                new Photo("https://images-na.ssl-images-amazon.com/images/I/519b58ZXcEL.jpg", true),
                new Photo("https://images-na.ssl-images-amazon.com/images/I/51dsDTSIUWL.jpg", true),
                new Photo("https://images-na.ssl-images-amazon.com/images/I/51UVWoZbFbL.jpg", true),
                new Photo("https://images-na.ssl-images-amazon.com/images/I/51eL5K6NyJL.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> lgTV = Stream.of(
                new Photo("https://target.scene7.com/is/image/Target/GUEST_106cc837-1aca-439a-95b6-edf462f22d8b?fmt=webp&wid=1400&qlt=80", true),
                new Photo("https://target.scene7.com/is/image/Target/GUEST_280c6509-daaa-46bc-b2f2-604a68b71f5e?fmt=webp&wid=1400&qlt=80", true),
                new Photo("https://target.scene7.com/is/image/Target/GUEST_6d87ca92-86d1-41a3-9173-dfd5f022b824?fmt=webp&wid=1400&qlt=80", true),
                new Photo("https://target.scene7.com/is/image/Target/GUEST_02ba825a-5271-43d8-9cef-e050ed7f96a9?fmt=webp&wid=1400&qlt=80", true)
        ).collect(Collectors.toSet());

        Set<Photo> samsungTV = Stream.of(
                new Photo("https://target.scene7.com/is/image/Target/GUEST_a45c6ce7-3a3e-49bb-a20b-afa2a5549289?fmt=webp&wid=1400&qlt=80", true),
                new Photo("https://target.scene7.com/is/image/Target/GUEST_f3e2e7a0-2edd-4f43-bf54-80a98bf85452?fmt=webp&wid=1400&qlt=80", true),
                new Photo("https://target.scene7.com/is/image/Target/GUEST_0787fa7d-25f0-455d-8e5f-890d54fa41b0?fmt=webp&wid=1400&qlt=80", true),
                new Photo("https://target.scene7.com/is/image/Target/GUEST_d3ed1faa-80d5-4bda-a8a0-5b8356ecae25?fmt=webp&wid=1400&qlt=80", true)
        ).collect(Collectors.toSet());

        Set<Photo> sonyTV = Stream.of(
                new Photo("https://ekupi.blob.core.windows.net/ekupiba/1628618.jpg", true),
                new Photo("https://ekupi.blob.core.windows.net/ekupiba/1628619.jpg", true),
                new Photo("https://ekupi.blob.core.windows.net/ekupiba/1628620.jpg", true),
                new Photo("https://ekupi.blob.core.windows.net/ekupiba/1628621.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> hisenseTV = Stream.of(
                new Photo("https://target.scene7.com/is/image/Target/GUEST_47efdb45-cde1-448c-b783-63fe2bd2dbc9?fmt=webp&wid=1400&qlt=80", true),
                new Photo("https://target.scene7.com/is/image/Target/GUEST_845102df-5aa6-4f87-a141-48b6bed29e7e?fmt=webp&wid=1400&qlt=80", true),
                new Photo("https://target.scene7.com/is/image/Target/GUEST_b7cd9526-6829-457d-9381-37aedde36299?fmt=webp&wid=1400&qlt=80", true),
                new Photo("https://target.scene7.com/is/image/Target/GUEST_6e4d7dcc-3e54-4499-9db7-95b934083ddb?fmt=webp&wid=1400&qlt=80", true)
        ).collect(Collectors.toSet());

        Set<Photo> lamp = Stream.of(
                new Photo("https://resources1.oka.com/assets/en/new/catalogue/1200x1200/A13196-2-21-1056-10_01.jpg?imgver=710", true),
                new Photo("https://resources1.oka.com/assets/en/new/catalogue/1200x1200/A13196-2-21-1056-10_04.jpg?imgver=710", true),
                new Photo("https://resources1.oka.com/assets/en/new/catalogue/1200x1200/A13196-2-21-1056-10_L1.jpg?imgver=710", true),
                new Photo("https://resources1.oka.com/assets/en/new/catalogue/1200x1200/A13196-2-21-1056-10_05.jpg?imgver=710", true)
        ).collect(Collectors.toSet());

        Set<Photo> ps5 = Stream.of(
                new Photo("https://edge.curalate.com/v1/img/fzBhCcVIgrNP7mtZf6_QzJv97ybWq1qySuQJg6oXPDg=/h/1200?compression=0.75", true),
                new Photo("https://target.scene7.com/is/image/Target/GUEST_9c41d78f-1155-4069-ab97-e2cef0ade1df?fmt=webp&wid=1400&qlt=80", true),
                new Photo("https://target.scene7.com/is/image/Target/GUEST_ae4e8352-bcea-4dd7-97ad-13be08ec32fb?fmt=webp&wid=1400&qlt=80", true)
        ).collect(Collectors.toSet());

        Set<Photo> xbox = Stream.of(
                new Photo("https://target.scene7.com/is/image/Target/GUEST_77e2a7ba-bfe8-435e-bc1e-01f2a7426e6c?fmt=webp&wid=1400&qlt=80", true),
                new Photo("https://target.scene7.com/is/image/Target/GUEST_350eb4ce-48a6-4503-9e6c-f59212b6b584?fmt=webp&wid=1400&qlt=80", true),
                new Photo("https://target.scene7.com/is/image/Target/GUEST_a1c5b963-333c-46f8-8c4b-1d4c4bad823c?fmt=webp&wid=1400&qlt=80", true),
                new Photo("https://target.scene7.com/is/image/Target/GUEST_a01bd9bf-8db1-4e3d-b0b7-29f0acd8e574?fmt=webp&wid=1400&qlt=80", true)
        ).collect(Collectors.toSet());

        Set<Photo> airConditioning = Stream.of(
                new Photo("https://target.scene7.com/is/image/Target/GUEST_f3bf1c3b-9965-4b64-b4a2-f5aab06a0a48?fmt=webp&wid=1400&qlt=80", true),
                new Photo("https://target.scene7.com/is/image/Target/GUEST_0cccdadb-013d-41c9-98ed-7f459620c4b4?fmt=webp&wid=1400&qlt=80", true),
                new Photo("https://target.scene7.com/is/image/Target/GUEST_5c7cb76f-3a41-46eb-b27c-0ab2db024cfe?fmt=webp&wid=1400&qlt=80", true)
        ).collect(Collectors.toSet());

        Set<Photo> carbonCase = Stream.of(
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/10/SC_101121683-3_1000X1000-600x600.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/10/SC_101121683-2_1000X1000-600x600.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/10/SC_101121683-11_1000X1000-600x600.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/10/SC_101121683-12_1000X1000-600x600.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> siliconCase = Stream.of(
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/07/jpg-600x600.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/07/6048006_0_f-100x100.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/03/jpg-1-600x600.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/03/jpg-600x600.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> wirelessCharger = Stream.of(
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/12/102001461A-1_1000X1000-600x600.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/12/102001461A-5_1000X1000-600x600.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/12/102001461A-7_1000X1000-600x600.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/12/102001461A-2_1000X1000.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> fastCharger = Stream.of(
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/12/adapter-sac-nhanh-qc3-0-18w-joyroom-l-q182-451254-600x600.jpeg", true),
                new Photo("https://cdn.mobile2000.com/pub/media/catalog/product/cache/325b082b36dfc73e92ef0282dbb63e01/j/o/joyroom_18w_qc3_q182.jpg", true),
                new Photo("https://img.sunsky-online.com/upload/store/detail_l/SAS53861_3.jpg", true),
                new Photo("https://img.sunsky-online.com/upload/store/detail_l/SAS53861_14.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> carCharger = Stream.of(
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/06/169921_oryg-600x600.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/06/169920_oryg-600x600.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/06/169919_oryg-600x600.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/06/169916_oryg-600x600.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> sonyHeadphones = Stream.of(
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/12/wh-xm1000-black-600x600.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/12/sony_wh-1000xm3_wireless_headphones_3.png", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/12/wh-xm1000-black1.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/12/wh-xm1000-black.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> wirelessHeadphones = Stream.of(
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/12/C0001715A-1_1000X1000.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/12/C0001715A-6_1000X1000.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/12/C0001715A-4_1000X1000.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/12/C0001715A-3_1000X1000.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> memoryCard = Stream.of(
                new Photo("https://images-na.ssl-images-amazon.com/images/I/617NtexaW2L._SL1500_.jpg", true),
                new Photo("https://images-na.ssl-images-amazon.com/images/I/71cs-unZZqL._SL1500_.jpg", true),
                new Photo("https://images-na.ssl-images-amazon.com/images/I/61P3Jhyw2DL._SL1000_.jpg", true),
                new Photo("https://images-na.ssl-images-amazon.com/images/I/71EqAhsQqPL._SL1500_.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> samsungScreenProtector = Stream.of(
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/11/88460_oryg-1.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/11/88461_oryg-1.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/11/88462_oryg-1.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/11/88460_oryg-1.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> lgScreenProtector = Stream.of(
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/11/slika-10817-5fa524f9a2a63-velika.jpg", true),
                new Photo("https://www.univerzalno.com/wp-content/uploads/2020/11/slika-10817-5fa524fb1ec24-velika.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> manWinterJacket = Stream.of(
                new Photo("https://www.jackjones.com/dw/image/v2/ABBT_PRD/on/demandware.static/-/Sites-pim-catalog/default/dwdca3ba52/pim-static/large/12180821_DarkNavy_003_ProductLarge.jpg?sw=95", true),
                new Photo("https://www.jackjones.com/dw/image/v2/ABBT_PRD/on/demandware.static/-/Sites-pim-catalog/default/dwe7873a0f/pim-static/large/12180821_DarkNavy_004_ProductLarge.jpg?sw=95", true),
                new Photo("https://www.jackjones.com/dw/image/v2/ABBT_PRD/on/demandware.static/-/Sites-pim-catalog/default/dwf5b698c7/pim-static/large/12180821_DarkNavy_005_ProductLarge.jpg?sw=95", true),
                new Photo("https://www.jackjones.com/dw/image/v2/ABBT_PRD/on/demandware.static/-/Sites-pim-catalog/default/dwfdaaed42/pim-static/large/12180821_DarkNavy_008_ProductLarge.jpg?sw=95", true)
        ).collect(Collectors.toSet());

        Set<Photo> womanWinterJacket = Stream.of(
                new Photo("https://columbia.scene7.com/is/image/ColumbiaSportswear2/1799752_472_f?wid=768&hei=806", true),
                new Photo("https://columbia.scene7.com/is/image/ColumbiaSportswear2/1799752_472_b?wid=768&hei=806", true)
        ).collect(Collectors.toSet());

        Set<Photo> womanSkiingJacket = Stream.of(
                new Photo("https://cdn-images.farfetch-contents.com/12/77/07/49/12770749_12764020_480.jpg", true),
                new Photo("https://cdn-images.farfetch-contents.com/12/77/07/49/12770749_12764023_1000.jpg", true),
                new Photo("https://cdn-images.farfetch-contents.com/12/77/07/49/12770749_12764030_1000.jpg", true),
                new Photo("https://cdn-images.farfetch-contents.com/12/77/07/49/12770749_12764027_1000.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> menSkiingJacket = Stream.of(
                new Photo("https://cdn-images.farfetch-contents.com/15/83/98/40/15839840_30311307_1000.jpg", true),
                new Photo("https://cdn-images.farfetch-contents.com/15/83/98/40/15839840_30310043_1000.jpg", true),
                new Photo("https://cdn-images.farfetch-contents.com/15/83/98/40/15839840_30311309_1000.jpg", true),
                new Photo("https://cdn-images.farfetch-contents.com/15/83/98/40/15839840_30311307_1000.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> menCoat = Stream.of(
                new Photo("https://www.jackjones.com/dw/image/v2/ABBT_PRD/on/demandware.static/-/Sites-pim-catalog/default/dwe4c62835/pim-static/large/12181565_DarkGreyMelange_003_ProductLarge.jpg?sw=685", true),
                new Photo("https://www.jackjones.com/dw/image/v2/ABBT_PRD/on/demandware.static/-/Sites-pim-catalog/default/dw01afd7cd/pim-static/large/12181565_DarkGreyMelange_004_ProductLarge.jpg?sw=685", true),
                new Photo("https://www.jackjones.com/dw/image/v2/ABBT_PRD/on/demandware.static/-/Sites-pim-catalog/default/dwa72ab79d/pim-static/large/12181565_DarkGreyMelange_005_ProductLarge.jpg?sw=685", true),
                new Photo("https://www.jackjones.com/dw/image/v2/ABBT_PRD/on/demandware.static/-/Sites-pim-catalog/default/dw81f7116a/pim-static/large/12181565_DarkGreyMelange_008_ProductLarge.jpg?sw=685", true)
        ).collect(Collectors.toSet());

        Set<Photo> womanCoat = Stream.of(
                new Photo("https://myspringfield.com/dw/image/v2/AAYL_PRD/on/demandware.static/-/Sites-gc-spf-master-catalog/default/dw03ad9dc2/images/hi-res/P_823911843FM.jpg?sw=600&sh=900&sm=fit", true),
                new Photo("https://myspringfield.com/dw/image/v2/AAYL_PRD/on/demandware.static/-/Sites-gc-spf-master-catalog/default/dw95e87733/images/hi-res/P_823911843TM.jpg?sw=600&sh=900&sm=fit", true),
                new Photo("https://myspringfield.com/dw/image/v2/AAYL_PRD/on/demandware.static/-/Sites-gc-spf-master-catalog/default/dw3c32c1e7/images/hi-res/P_823911843D2.jpg?sw=600&sh=900&sm=fit", true),
                new Photo("https://myspringfield.com/dw/image/v2/AAYL_PRD/on/demandware.static/-/Sites-gc-spf-master-catalog/default/dw41fb70d5/images/hi-res/P_823911843D3.jpg?sw=600&sh=900&sm=fit", true)
        ).collect(Collectors.toSet());

        Set<Photo> stoneJacket = Stream.of(
                new Photo("https://cdn.shopify.com/s/files/1/0556/1841/products/george_30.10.20186.jpg?v=1604091252", true),
                new Photo("https://cdn.shopify.com/s/files/1/0556/1841/products/george_30.10.20188.jpg?v=1604091252", true),
                new Photo("https://cdn.shopify.com/s/files/1/0556/1841/products/george_30.10.20187.jpg?v=1604091253", true)
        ).collect(Collectors.toSet());

        Set<Photo> vintageWoman = Stream.of(
                new Photo("https://cdn.shopify.com/s/files/1/0556/1841/products/george_womens_08.12.20468.jpg?v=1607549639", true),
                new Photo("https://cdn.shopify.com/s/files/1/0556/1841/products/george_womens_08.12.20470.jpg?v=1607549640", true),
                new Photo("https://cdn.shopify.com/s/files/1/0556/1841/products/george_womens_08.12.20469.jpg?v=1607549641", true)
        ).collect(Collectors.toSet());

        Set<Photo> manWedding = Stream.of(
                new Photo("https://www.politix.com.au/dw/image/v2/ABBA_PRD/on/demandware.static/-/Sites-politix-master-catalog/default/dwde794ee5/images/hires/Winter20/Y3/YJ05/yj05-blk-wht-check-1.jpg?sw=2000&sh=2000&sm=fit", true),
                new Photo("https://www.politix.com.au/dw/image/v2/ABBA_PRD/on/demandware.static/-/Sites-politix-master-catalog/default/dw0687f81a/images/hires/Winter20/Y3/YJ05/yj05-blk-wht-check-2.jpg?sw=2000&sh=2000&sm=fit", true),
                new Photo("https://www.politix.com.au/dw/image/v2/ABBA_PRD/on/demandware.static/-/Sites-politix-master-catalog/default/dw4c739a87/images/hires/Winter20/Y3/YJ05/yj05-blk-wht-check-3.jpg?sw=2000&sh=2000&sm=fit", true),
                new Photo("https://www.politix.com.au/dw/image/v2/ABBA_PRD/on/demandware.static/-/Sites-politix-master-catalog/default/dwa4fdf3f0/images/hires/Winter20/Y3/YJ05/yj05-blk-wht-check-4.jpg?sw=2000&sh=2000&sm=fit", true)
        ).collect(Collectors.toSet());

        Set<Photo> weddingGown = Stream.of(
                new Photo("https://morilee-dev.s3.amazonaws.com/wp-content/uploads/sites/3/2020/11/12132921/2303-0012-scaled-INTERNATIONAL.jpg", true),
                new Photo("https://morilee-dev.s3.amazonaws.com/wp-content/uploads/sites/3/2020/11/12134719/2303-0242-scaled-INTERNATIONAL.jpg", true),
                new Photo("https://morilee-dev.s3.amazonaws.com/wp-content/uploads/sites/3/2020/11/12134729/Morilee_Fall2020_Bridal_2303Bonita_2-scaled-INTERNATIONAL.jpg", true),
                new Photo("https://morilee-dev.s3.amazonaws.com/wp-content/uploads/sites/3/2020/11/12134740/Morilee_Fall2020_Bridal_2303Bonita_7-scaled-INTERNATIONAL.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> manHat = Stream.of(
                new Photo("https://www.hats.com/media/catalog/product/C/G/CG168OE-Country-Gentleman-Boyd-Fedora-Taupe-1.jpg?quality=80&bg-color=255,255,255&fit=bounds&height=600&width=600&canvas=600:600", true),
                new Photo("https://www.hats.com/media/catalog/product/c/g/cg168oe-country-gentleman-boyd-fedora-taupe-6_1.jpg?quality=80&bg-color=255,255,255&fit=bounds&height=600&width=600&canvas=600:600", true),
                new Photo("https://www.hats.com/media/catalog/product/c/g/cg168oe-country-gentleman-boyd-fedora-taupe-304_1.jpg?quality=80&bg-color=255,255,255&fit=bounds&height=600&width=600&canvas=600:600", true),
                new Photo("https://www.hats.com/media/catalog/product/c/g/cg168oe-country-gentleman-boyd-fedora-taupe-307_1.jpg?quality=80&bg-color=255,255,255&fit=bounds&height=600&width=600&canvas=600:600", true)
        ).collect(Collectors.toSet());

        Set<Photo> casualHat = Stream.of(
                new Photo("https://www.hats.com/media/catalog/product/K/a/Kangol-Furgora-Casual-Bucket-Moss-Grey-MAIN-792179724176-1978.jpg?quality=80&bg-color=255,255,255&fit=bounds&height=600&width=600&canvas=600:600", true),
                new Photo("https://www.hats.com/media/catalog/product/K/a/Kangol-Furgora-Casual-Bucket-Old-Gold-MAIN-792179724213-5999.jpg?quality=80&bg-color=255,255,255&fit=bounds&height=600&width=600&canvas=600:600", true),
                new Photo("https://www.hats.com/media/catalog/product/K/a/Kangol-Furgora-Casual-Bucket-Fiery-Orange-MAIN-792179724138-5812.jpg?quality=80&bg-color=255,255,255&fit=bounds&height=600&width=600&canvas=600:600", true),
                new Photo("https://www.hats.com/media/catalog/product/K/3/K3017ST_SC613_MAIN.jpg?quality=80&bg-color=255,255,255&fit=bounds&height=600&width=600&canvas=600:600", true)
        ).collect(Collectors.toSet());

        Set<Photo> manPoloShirt = Stream.of(
                new Photo("https://myspringfield.com/dw/image/v2/AAYL_PRD/on/demandware.static/-/Sites-gc-spf-master-catalog/default/dw542567e7/images/hi-res/P_855102212FM.jpg?sw=600&sh=900&sm=fit", true),
                new Photo("https://myspringfield.com/dw/image/v2/AAYL_PRD/on/demandware.static/-/Sites-gc-spf-master-catalog/default/dw9d214346/images/hi-res/P_855102212D2.jpg?sw=600&sh=900&sm=fit", true),
                new Photo("https://myspringfield.com/dw/image/v2/AAYL_PRD/on/demandware.static/-/Sites-gc-spf-master-catalog/default/dw33259d68/images/hi-res/P_855102212D1.jpg?sw=600&sh=900&sm=fit", true),
                new Photo("https://myspringfield.com/dw/image/v2/AAYL_PRD/on/demandware.static/-/Sites-gc-spf-master-catalog/default/dw436d0a43/images/hi-res/P_855102212TM.jpg?sw=600&sh=900&sm=fit", true)
        ).collect(Collectors.toSet());

        Set<Photo> manPullover = Stream.of(
                new Photo("https://myspringfield.com/dw/image/v2/AAYL_PRD/on/demandware.static/-/Sites-gc-spf-master-catalog/default/dw611f30e5/images/hi-res/P_140863169FM.jpg?sw=600&sh=900&sm=fit", true),
                new Photo("https://myspringfield.com/dw/image/v2/AAYL_PRD/on/demandware.static/-/Sites-gc-spf-master-catalog/default/dwbd2109b8/images/hi-res/P_140863169TM.jpg?sw=600&sh=900&sm=fit", true),
                new Photo("https://myspringfield.com/dw/image/v2/AAYL_PRD/on/demandware.static/-/Sites-gc-spf-master-catalog/default/dw7c8902e7/images/hi-res/P_140863169D1.jpg?sw=600&sh=900&sm=fit", true)
        ).collect(Collectors.toSet());

        Set<Photo> swimmingGlassesPhoto = Stream.of(
                new Photo("https://contents.mediadecathlon.com/p1242428/2f5fd25f23822747832eb006bf1692b8/p1242428.jpg?f=650x650&format=auto", true),
                new Photo("https://contents.mediadecathlon.com/p1242427/5a2f09d2b4f90580046073dd1474b5e8/p1242427.jpg?f=650x650&format=auto", true),
                new Photo("https://contents.mediadecathlon.com/p1242430/0aeea81bb608e20e6fdc33cfde4a76f8/p1242430.jpg?f=650x650&format=auto", true),
                new Photo("https://contents.mediadecathlon.com/p1242429/4a1356862c7189320597145be342b50b/p1242429.jpg?f=650x650&format=auto", true)
        ).collect(Collectors.toSet());

        Set<Photo> bvlgariBag = Stream.of(
                new Photo("https://images.selfridges.com/is/image/selfridges/R03704205_BLACK_M?$PDP_M_ZOOM$", true),
                new Photo("https://images.selfridges.com/is/image/selfridges/R03704205_BLACK_ALT01?$PDP_M_ZOOM$", true),
                new Photo("https://images.selfridges.com/is/image/selfridges/R03704205_BLACK_ALT02?$PDP_M_ZOOM$", true),
                new Photo("https://images.selfridges.com/is/image/selfridges/R03704205_BLACK_ALT03?$PDP_M_ZOOM$", true)
        ).collect(Collectors.toSet());

        Set<Photo> gucciBag = Stream.of(
                new Photo("https://images.selfridges.com/is/image/selfridges/R03678442_BROWNBEIGENAVY_M?$PDP_M_ZOOM$", true),
                new Photo("https://images.selfridges.com/is/image/selfridges/R03678442_BROWNBEIGENAVY_ALT01?$PDP_M_ZOOM$", true),
                new Photo("https://images.selfridges.com/is/image/selfridges/R03678442_BROWNBEIGENAVY_ALT02?$PDP_M_ZOOM$", true),
                new Photo("https://images.selfridges.com/is/image/selfridges/R03678442_BROWNBEIGENAVY_ALT03?$PDP_M_ZOOM$", true)
        ).collect(Collectors.toSet());

        Set<Photo> pradaBackpack = Stream.of(
                new Photo("https://images.selfridges.com/is/image/selfridges/R03718542_BLACK_M?$PDP_M_ZOOM$", true),
                new Photo("https://images.selfridges.com/is/image/selfridges/R03718542_BLACK_ALT01?$PDP_M_ZOOM$", true),
                new Photo("https://images.selfridges.com/is/image/selfridges/R03718542_BLACK_ALT02?$PDP_M_ZOOM$", true)
        ).collect(Collectors.toSet());

        Set<Photo> manRayBan = Stream.of(
                new Photo("https://cdn-images.farfetch-contents.com/11/31/86/98/11318698_6476499_480.jpg", true),
                new Photo("https://cdn-images.farfetch-contents.com/11/31/86/98/11318698_6476500_1000.jpg", true),
                new Photo("https://cdn-images.farfetch-contents.com/11/31/86/98/11318698_6476501_480.jpg", true),
                new Photo("https://img1-image.cdnsbg.com/new_packagings/600x/14_s.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> manAviator = Stream.of(
                new Photo("https://cdn-images.farfetch-contents.com/12/09/86/32/12098632_9897567_1000.jpg", true),
                new Photo("https://cdn-images.farfetch-contents.com/12/09/86/32/12098632_9897568_1000.jpg", true),
                new Photo("https://cdn-images.farfetch-contents.com/12/09/86/32/12098632_9897569_480.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> womanRayBan = Stream.of(
                new Photo("https://cdn-images.farfetch-contents.com/13/34/08/53/13340853_15710167_1000.jpg", true),
                new Photo("https://cdn-images.farfetch-contents.com/13/34/08/53/13340853_15710168_1000.jpg", true),
                new Photo("https://cdn-images.farfetch-contents.com/13/34/08/53/13340853_15710170_1000.jpg", true),
                new Photo("https://img1-image.cdnsbg.com/new_packagings/600x/14_s.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> womanGuess = Stream.of(
                new Photo("https://cdn-images.farfetch-contents.com/14/75/49/76/14754976_23944304_480.jpg", true),
                new Photo("https://cdn-images.farfetch-contents.com/14/75/49/76/14754976_23944307_480.jpg", true),
                new Photo("https://cdn-images.farfetch-contents.com/14/75/49/76/14754976_23944313_1000.jpg", true),
                new Photo("https://cdn-images.farfetch-contents.com/14/75/49/76/14754976_23944309_1000.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> clothMask = Stream.of(
                new Photo("https://cdn.shopify.com/s/files/1/0123/5065/2473/products/BUCK-MASON-BLACK-FACE-MASK-3.jpg?v=1607030924", true),
                new Photo("https://cdn.shopify.com/s/files/1/0123/5065/2473/products/BUCK-MASON-BLACK-FACE-MASK.jpg?v=1607030924", true),
                new Photo("https://cdn.shopify.com/s/files/1/0123/5065/2473/products/BUCK-MASON-BLACK-FACE-MASK-2.jpg?v=1607030924", true)
        ).collect(Collectors.toSet());

        Set<Photo> clothBandana = Stream.of(
                new Photo("https://cdn.shopify.com/s/files/1/0123/5065/2473/products/Navy-Farmed-Cotton-Bandana-9062.jpg?v=1591308952", true),
                new Photo("https://cdn.shopify.com/s/files/1/0123/5065/2473/products/Navy-Farmed-Cotton-Bandana-SINGLE.jpg?v=1591308953", true),
                new Photo("https://cdn.shopify.com/s/files/1/0123/5065/2473/products/Navy-Farmed-Cotton-Bandana-LOOP.jpg?v=1591308952", true),
                new Photo("https://cdn.shopify.com/s/files/1/0123/5065/2473/products/Navy-Farmed-Cotton-DETAIL.jpg?v=1591308952", true)
        ).collect(Collectors.toSet());

        Set<Photo> engagementRing = Stream.of(
                new Photo("https://media.tiffany.com/is/image/Tiffany/EcomItemM/the-tiffany-setting-engagement-ring-in-platinum-22086588_995766_ED_M.jpg?&op_usm=1.75,1.0,6.0&$cropN=0.1,0.1,0.8,0.8&defaultImage=NoImageAvailableInternal&", true),
                new Photo("https://media.tiffany.com/is/image/Tiffany/EcomItemM/the-tiffany-setting-engagement-ring-in-platinum-22086588_995767_AV_1_M.jpg?&op_usm=1.75,1.0,6.0&defaultImage=NoImageAvailableInternal&", true),
                new Photo("https://media.tiffany.com/is/image/Tiffany/EcomItemM/the-tiffany-setting-engagement-ring-in-platinum-22086588_995768_AV_2_M.jpg?&op_usm=1.75,1.0,6.0&defaultImage=NoImageAvailableInternal&", true)
        ).collect(Collectors.toSet());

        Set<Photo> silverBracelet = Stream.of(
                new Photo("https://media.tiffany.com/is/image/Tiffany/EcomItemM/tiffany-victoriatennis-bracelet-13674108_993665_ED.jpg?&op_usm=1.0,1.0,6.0&$cropN=0.1,0.1,0.8,0.8&defaultImage=NoImageAvailableInternal&", true),
                new Photo("https://media.tiffany.com/is/image/Tiffany/EcomItemM/tiffany-victoriatennis-bracelet-13674108_993663_AV_1.jpg?&op_usm=1.0,1.0,6.0&defaultImage=NoImageAvailableInternal&", true),
                new Photo("https://media.tiffany.com/is/image/Tiffany/EcomItemM/tiffany-victoriatennis-bracelet-13674108_994310_AV_2.jpg?&op_usm=1.0,1.0,6.0&defaultImage=NoImageAvailableInternal&", true),
                new Photo("https://media.tiffany.com/is/image/Tiffany/EcomItemM/tiffany-victoriatennis-bracelet-13674108_993664_AV_3.jpg?&op_usm=1.0,1.0,6.0&defaultImage=NoImageAvailableInternal&", true)
        ).collect(Collectors.toSet());

        Set<Photo> roseGoldBracelet = Stream.of(
                new Photo("https://media.tiffany.com/is/image/Tiffany/EcomItemM/tiffany-victoriatennis-bracelet-32948243_993674_ED.jpg?&op_usm=1.0,1.0,6.0&$cropN=0.1,0.1,0.8,0.8&defaultImage=NoImageAvailableInternal&", true),
                new Photo("https://media.tiffany.com/is/image/Tiffany/EcomItemM/tiffany-victoriatennis-bracelet-32948243_993672_AV_1.jpg?&op_usm=1.0,1.0,6.0&defaultImage=NoImageAvailableInternal&", true),
                new Photo("https://media.tiffany.com/is/image/Tiffany/EcomItemM/tiffany-victoriatennis-bracelet-32948243_994321_AV_2.jpg?&op_usm=1.0,1.0,6.0&defaultImage=NoImageAvailableInternal&", true),
                new Photo("https://media.tiffany.com/is/image/Tiffany/EcomItemM/tiffany-victoriatennis-bracelet-32948243_993673_AV_3.jpg?&op_usm=1.0,1.0,6.0&defaultImage=NoImageAvailableInternal&", true)
        ).collect(Collectors.toSet());

        Set<Photo> rosegoldRing = Stream.of(
                new Photo("https://media.tiffany.com/is/image/Tiffany/EcomItemM/tiffany-tt1-wide-diamond-ring-68169712_1010247_ED_M.jpg?&op_usm=1.75,1.0,6.0&$cropN=0.1,0.1,0.8,0.8&defaultImage=NoImageAvailableInternal&", true),
                new Photo("https://media.tiffany.com/is/image/Tiffany/EcomItemM/tiffany-tt1-wide-diamond-ring-68169712_1010245_AV_1_M.jpg?&op_usm=1.75,1.0,6.0&defaultImage=NoImageAvailableInternal&", true),
                new Photo("https://media.tiffany.com/is/image/Tiffany/EcomItemM/tiffany-tt1-wide-diamond-ring-68169712_1010246_AV_2_M.jpg?&op_usm=1.75,1.0,6.0&defaultImage=NoImageAvailableInternal&", true)
        ).collect(Collectors.toSet());

        Set<Photo> silverRing = Stream.of(
                new Photo("https://media.tiffany.com/is/image/Tiffany/EcomItemM/tiffany-victoriadiamond-vine-ring-in-platinum-63914673_1002635_ED_M.jpg?&op_usm=1.75,1.0,6.0&$cropN=0.1,0.1,0.8,0.8&defaultImage=NoImageAvailableInternal&", true),
                new Photo("https://media.tiffany.com/is/image/Tiffany/EcomItemM/tiffany-victoriadiamond-vine-ring-in-platinum-63914673_1002636_AV_1_M.jpg?&op_usm=1.75,1.0,6.0&defaultImage=NoImageAvailableInternal&", true),
                new Photo("https://media.tiffany.com/is/image/Tiffany/EcomItemM/tiffany-victoriadiamond-vine-ring-in-platinum-63914673_1002637_AV_2_M.jpg?&op_usm=1.75,1.0,6.0&defaultImage=NoImageAvailableInternal&", true)
        ).collect(Collectors.toSet());

        Set<Photo> bodyPiercing = Stream.of(
                new Photo("https://cdn.shopify.com/s/files/1/1259/1581/products/66916.otherimage1_grande.jpg?v=1569142626", true),
                new Photo("https://cdn.shopify.com/s/files/1/1259/1581/products/66916.otherimage2_grande.jpg?v=1569142626", true)
        ).collect(Collectors.toSet());

        Set<Photo> charm = Stream.of(
                new Photo("https://media.tiffany.com/is/image/Tiffany/EcomItemM/tiffany-charmsbirthday-candle-charm-62385227_989251_ED.jpg?&op_usm=2.0,1.0,6.0&$cropN=0.1,0.1,0.8,0.8&defaultImage=NoImageAvailableInternal&", true),
                new Photo("https://media.tiffany.com/is/image/Tiffany/EcomItemM/tiffany-charmsbirthday-candle-charm-62385227_989250_AV_1.jpg?&op_usm=2.0,1.0,6.0&defaultImage=NoImageAvailableInternal&", true)
        ).collect(Collectors.toSet());

        Set<Photo> winterManShoes = Stream.of(
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/FV6863_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/FV6863_1_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/FV6863_2_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/FV6863_3_600_600px.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> womanWinterShoes = Stream.of(
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/FW9758_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/FW9758_1_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/FW9758_2_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/FW9758_3_600_600px.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> boyWinterShoes = Stream.of(
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/D97655_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/D97655_2_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/D97655_3_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/D97655_4_600_600px.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> girlWinterShoes = Stream.of(
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/D97656_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/D97656_1_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/D97656_3_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/D97656_4_600_600px.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> nikeCourt = Stream.of(
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/CD5463-104_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/CD5463-104_3_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/CD5463-104_4_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/CD5463-104_4_600_600px.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> nikeAirforce = Stream.of(
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/nike/thumbs_600/CT2858-200_600_600px.jpg", true),
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/nike/thumbs_600/CT2858-200_2_600_600px.jpg", true),
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/nike/thumbs_600/CT2858-200_3_600_600px.jpg", true),
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/nike/thumbs_600/CT2858-200_4_600_600px.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> airMax2090 = Stream.of(
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/nike/thumbs_600/BV9977-800_600_600px.jpg", true),
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/nike/thumbs_600/BV9977-800_2_600_600px.jpg", true),
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/nike/thumbs_600/BV9977-800_3_600_600px.jpg", true),
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/nike/thumbs_600/BV9977-800_4_600_600px.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> gazelle = Stream.of(
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/adidas/thumbs_600/BB5476_600_600px.jpg", true),
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/adidas/thumbs_600/BB5476_2_600_600px.jpg", true),
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/adidas/thumbs_600/BB5476_3_600_600px.jpg", true),
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/adidas/thumbs_600/BB5476_4_600_600px.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> nikeWomanJordan = Stream.of(
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/nike/thumbs_600/DC0774-005_600_600px.jpg", true),
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/nike/thumbs_600/DC0774-005_2_600_600px.jpg", true),
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/nike/thumbs_600/DC0774-005_3_600_600px.jpg", true),
                new Photo("https://www.buzzsneakers.com/files/thumbs/files/images/product/brand/nike/thumbs_600/DC0774-005_4_600_600px.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> pumaShoes = Stream.of(
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/365277-07_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/365277-07_2_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/365277-07_3_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/365277-07_4_600_600px.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> reebokShoes = Stream.of(
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/FX0154_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/FX0154_2_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/FX0154_3_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/FX0154_4_600_600px.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> classyShoeMan = Stream.of(
                new Photo("https://astra.ba/wp-content/uploads/2019/04/79893-2.jpg", true),
                new Photo("https://astra.ba/wp-content/uploads/2019/04/79893-4.jpg", true),
                new Photo("https://astra.ba/wp-content/uploads/2019/04/79893-5.jpg", true),
                new Photo("https://astra.ba/wp-content/uploads/2019/04/79893-1.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> classyBlueShoeMan = Stream.of(
                new Photo("https://astra.ba/wp-content/uploads/2019/04/79889-1.jpg", true),
                new Photo("https://astra.ba/wp-content/uploads/2019/04/79889-2.jpg", true),
                new Photo("https://astra.ba/wp-content/uploads/2019/04/79889-4.jpg", true),
                new Photo("https://astra.ba/wp-content/uploads/2019/04/79889-6.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> spottedHeels = Stream.of(
                new Photo("https://astra.ba/wp-content/uploads/2019/04/77839-1.jpg", true),
                new Photo("https://astra.ba/wp-content/uploads/2019/04/77839-2.jpg", true),
                new Photo("https://astra.ba/wp-content/uploads/2019/04/77839-3.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> feralHeals = Stream.of(
                new Photo("https://astra.ba/wp-content/uploads/2019/04/77843-1.jpg", true),
                new Photo("https://astra.ba/wp-content/uploads/2019/04/77843-2.jpg", true),
                new Photo("https://astra.ba/wp-content/uploads/2019/04/77843-3.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> summerManShoes = Stream.of(
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/CT6619-100_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/CT6619-100_1_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/CT6619-100_2_600_600px.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> summerWomanShoes = Stream.of(
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/EG1886_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/EG1886_1_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/EG1886_2_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/EG1886_3_600_600px.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> underArmourTankTop = Stream.of(
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/1356866-002_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/1356866-002_1_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/1356866-002_3_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/1356866-002_4_600_600px.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> adidasTrainingShirt = Stream.of(
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/GK8161_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/GK8161_1_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/GK8161_2_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/GK8161_3_600_600px.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> gymWaterBottle = Stream.of(
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/FM9935_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/FM9935_1_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/FM9935_2_600_600px.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> fitnessBall = Stream.of(
                new Photo("https://www.technogym.com/media/catalog/product/cache/1/image/1000x/040ec09b1e35df139433887a97daa66f/f/i/fitness_ball_hero_2.jpg", true),
                new Photo("https://www.technogym.com/media/catalog/product/cache/1/image/1000x/040ec09b1e35df139433887a97daa66f/f/i/fitness_ball_gallery_01_2.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> resistanceBand = Stream.of(
                new Photo("https://www.power-systems.com/shop/images/variant/large/6486.jpg", true),
                new Photo("https://www.power-systems.com/shop/images/product/large/3336_2_.jpg", true),
                new Photo("https://www.power-systems.com/shop/images/product/large/3336_3_.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> helmet = Stream.of(
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/101209001_600_600px.jpg", true),
                new Photo("https://www.sportvision.ba/files/thumbs/files/images/slike_proizvoda/thumbs_600/101209001_1_600_600px.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> balconySet = Stream.of(
                new Photo("https://secure.img1-fg.wfcdn.com/im/38398865/resize-h800-w800%5Ecompr-r85/3041/30413768/Grampian+3+Piece+Bistro+Set+with+Cushions.jpg", true),
                new Photo("https://secure.img1-fg.wfcdn.com/im/41318794/resize-h800-w800%5Ecompr-r85/8627/86270112/Grampian+3+Piece+Bistro+Set+with+Cushions.jpg", true),
                new Photo("https://secure.img1-fg.wfcdn.com/im/93482254/resize-h800-w800%5Ecompr-r85/3041/30413637/Grampian+3+Piece+Bistro+Set+with+Cushions.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> kitchenSet = Stream.of(
                new Photo("https://www.prodecocabinet.com/wp-content/uploads/2019/03/PRODECO-3D-060.jpg", true),
                new Photo("https://www.prodecocabinet.com/wp-content/uploads/2019/03/PRODECO-3D-059.jpg", true),
                new Photo("https://www.prodecocabinet.com/wp-content/uploads/2019/03/PRODECO-3D-061.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> bathCover = Stream.of(
                new Photo("https://cdn2.jysk.com/getimage/wd2.large/112104", true),
                new Photo("https://cdn2.jysk.com/getimage/wd2.large/113194", true),
                new Photo("https://cdn2.jysk.com/getimage/wd2.large/112105", true)
        ).collect(Collectors.toSet());

        Set<Photo> livingRoomSet = Stream.of(
                new Photo("https://secure.img1-fg.wfcdn.com/im/92543017/resize-h800-w800%5Ecompr-r85/1292/129299767/Altis+77%2522+Wide+Cotton+Square+Arm+Convertible+Sofa.jpg", true),
                new Photo("https://secure.img1-fg.wfcdn.com/im/45513272/resize-h800-w800%5Ecompr-r85/1292/129299757/Altis+77%2522+Wide+Cotton+Square+Arm+Convertible+Sofa.jpg", true),
                new Photo("https://secure.img1-fg.wfcdn.com/im/57020627/resize-h800-w800%5Ecompr-r85/1292/129299763/Altis+77%2522+Wide+Cotton+Square+Arm+Convertible+Sofa.jpg", true),
                new Photo("https://secure.img1-fg.wfcdn.com/im/26595756/resize-h800-w800%5Ecompr-r85/1292/129299764/Altis+77%2522+Wide+Cotton+Square+Arm+Convertible+Sofa.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> kidsRoomBed = Stream.of(
                new Photo("https://secure.img1-fg.wfcdn.com/im/62922521/resize-h800-w800%5Ecompr-r85/4032/40328102/Suzanne+Twin+over+Full+Bunk+Bed.jpg", true),
                new Photo("https://secure.img1-fg.wfcdn.com/im/08248943/resize-h800-w800%5Ecompr-r85/3882/38820650/Suzanne+Twin+over+Full+Bunk+Bed.jpg", true),
                new Photo("https://secure.img1-fg.wfcdn.com/im/63842350/resize-h800-w800%5Ecompr-r85/1167/116798500/Suzanne+Twin+over+Full+Bunk+Bed.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> ram = Stream.of(
                new Photo("https://procomp.ba/44530-thickbox_default/4gb-ddr4-2666mhz.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> rtx2080 = Stream.of(
                new Photo("https://procomp.ba/17151-thickbox_default/gigabyte-nvidia-geforce-rtx-2080-ti-gaming-oc-11gb-gddr6-352bit.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> kasperskySoftware = Stream.of(
                new Photo("https://procomp.ba/13187-thickbox_default/kaspersky-internet-security.jpg", true)
        ).collect(Collectors.toSet());

        Set<Photo> gamingPc = Stream.of(
                new Photo("https://www.cyberpowerpc.com/images/cs/corsair4000dair/cs-429-144_400.png", true),
                new Photo("https://www.cyberpowerpc.com/images/cs/corsair4000dair/blk_400.png", true),
                new Photo("https://www.cyberpowerpc.com/images/cs/corsair4000dair/blk01_400.png", true),
                new Photo("https://www.cyberpowerpc.com/images/cs/corsair4000dair/blk02_400.png", true)
        ).collect(Collectors.toSet());

        listOfProducts.add(new Product("Unisex running Shoes", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero. ", 240.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), runningShoes, "Black"));
        listOfProducts.add(new Product("Nike running shoes", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 110.00, new Date(), new Date("2019/12/23"), true, false, listOfUsers.get(3), runningShoes2, "Brown"));
        listOfProducts.add(new Product("Adidas running shoes", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 110.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), runningShoes3, "White"));
        listOfProducts.add(new Product("Under armour shoes", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 110.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), runningShoes4, "Red"));

        listOfProducts.add(new Product("Apple iPhone 11 Pro Max", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero. ", 1999.00, new Date(), new Date("2020/12/21 13:55:12"), true, false, listOfUsers.get(3), iPhone11Pro, "Gray"));
        listOfProducts.add(new Product("Apple iPhone X 64GB", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero. ", 1099.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), iPhoneX, "Black"));
        listOfProducts.add(new Product("Apple iPhone XR", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero. ", 900.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), iPhoneXr, "White"));
        listOfProducts.add(new Product("Samsung Galaxy S20 phone″", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero. ", 1440.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), s20, "Blue"));

        listOfProducts.add(new Product("HP ProBook G7 Laptop", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero. ", 1299.95, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), hpG7, "Gray"));
        listOfProducts.add(new Product("MacBook Pro 13 Laptop” ", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 2779.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), macbookPro, "Gray"));
        listOfProducts.add(new Product("Lenovo ThinkPad Laptop” ", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 1779.00, new Date(), new Date("2020/11/21"), true, false, listOfUsers.get(1), lenovo, "Black"));
        listOfProducts.add(new Product("Dell XPS Laptop” ", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 1999.00, new Date(), new Date("2020/11/21"), true, false, listOfUsers.get(1), dell, "Blue"));

        listOfProducts.add(new Product("LG UHD TV", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 1099.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), lgTV, "Gray"));
        listOfProducts.add(new Product("Samsung UHD TV", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 1199.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), samsungTV, "Black"));
        listOfProducts.add(new Product("Sony 4K TV", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 1299.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(3), sonyTV, "Black"));
        listOfProducts.add(new Product("Hisense TV", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 549.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(3), hisenseTV, "Black"));

        listOfProducts.add(new Product("Tissot V8 watch", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 4550.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(2), tissot, "White"));
        listOfProducts.add(new Product("Mens Rolex Submariner watch", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 10999.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), rolex, "Green"));
        listOfProducts.add(new Product("Tag Heuer Carrera watch", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 4525.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), tagheuer, "Black"));
        listOfProducts.add(new Product("Omega Speedmaster watch", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 9000.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), omega, "Blue"));

        listOfProducts.add(new Product("Golden necklace.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 1110.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(2), goldenNecklace, "White"));
        listOfProducts.add(new Product("Gold pendant necklace", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 1120.00, new Date(), new Date("2020/12/01"), true, false, listOfUsers.get(0), goldenPendant, "Yellow"));
        listOfProducts.add(new Product("Rose gold pendant necklace", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 1120.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), rosePendant, "Red"));
        listOfProducts.add(new Product("Diamond vine necklace", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 1120.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(2), diamondVine, "White"));

        listOfProducts.add(new Product("Womans tracksuit", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 110.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(3), womansTracksuit, "White"));
        listOfProducts.add(new Product("Mens tracksuit", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 110.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), mensTracksuit, "Black"));
        listOfProducts.add(new Product("Womans yoga pants", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 110.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), womenYoga, "Blue"));
        listOfProducts.add(new Product("Mens shorts", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 110.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(2), menShorts, "Gray"));

        listOfProducts.add(new Product("Single bed", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 410.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), bed, "White"));
        listOfProducts.add(new Product("King size bed", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 810.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(3), kingsize, "Blue"));
        listOfProducts.add(new Product("Bed cover", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 90.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(2), cover, "Blue"));
        listOfProducts.add(new Product("Bunk bed", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 560.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), bunkbed, "Gray"));

        listOfProducts.add(new Product("Built in oven", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 699.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), builtInOven, "Black"));
        listOfProducts.add(new Product("Microwave", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 249.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(2), microwave, "Gray"));
        listOfProducts.add(new Product("Dishwasher", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 499.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), dishwasher, "White"));
        listOfProducts.add(new Product("Washing machine", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 599.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), washingMachine, "White"));

        listOfProducts.add(new Product("Suit", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 250.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), suit, "White"));
        listOfProducts.add(new Product("Woman dress", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 150.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(2), dress, "Red"));
        listOfProducts.add(new Product("Hats", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 110.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), hats, "Yellow"));
        listOfProducts.add(new Product("Woman Sunglasses", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 149.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(3), sunglasses, "Black"));

        listOfProducts.add(new Product("Hammer", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 49.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(3), hammer, "Green"));
        listOfProducts.add(new Product("Cutter", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 49.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(2), cutter, "Red"));
        listOfProducts.add(new Product("Axe", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 39.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), axe, "Green"));
        listOfProducts.add(new Product("Saw", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 39.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), saw, "Orange"));

        listOfProducts.add(new Product("Harry Potter", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 60.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(2), harryPotter, "Red"));
        listOfProducts.add(new Product("The Godfather", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 60.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(3), theGodfather, "Black"));
        listOfProducts.add(new Product("The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 60.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), lotr, "White"));
        listOfProducts.add(new Product("Hyperion", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 60.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), hyperion, "Blue"));

        listOfProducts.add(new Product("Floor lamp", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 119.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), lamp, "Gray"));

        listOfProducts.add(new Product("Play Station 5 Console", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 499.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), ps5, "White"));
        listOfProducts.add(new Product("Xbox Series X Console", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 499.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(2), xbox, "Black"));

        listOfProducts.add(new Product("Air conditioning", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 699.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(3), airConditioning, "White"));

        listOfProducts.add(new Product("Carbon mobile case", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 9.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(3), carbonCase, "Black"));
        listOfProducts.add(new Product("Silicon mobile case", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 9.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), siliconCase, "White"));
        listOfProducts.add(new Product("Wireless Charger 3 in 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 79.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), wirelessCharger, "Black"));
        listOfProducts.add(new Product("Fast mobile charger", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 39.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(3), fastCharger, "Black"));
        listOfProducts.add(new Product("Car mobile charger", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 39.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(2), carCharger, "White"));

        listOfProducts.add(new Product("Sony WH-1000XM3 headphones", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 399.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), sonyHeadphones, "Black"));
        listOfProducts.add(new Product("XG8 TWS Wireless headphones", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 89.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), wirelessHeadphones, "Black"));

        listOfProducts.add(new Product("Memory Card 128GB", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 19.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(2), memoryCard, "Black"));
        listOfProducts.add(new Product("Samsung screen protector", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 5.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), samsungScreenProtector, "Black"));
        listOfProducts.add(new Product("Iphone screen protector", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 5.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), lgScreenProtector, "Black"));

        listOfProducts.add(new Product("Man winter jacket", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 399.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), manWinterJacket, "Black"));
        listOfProducts.add(new Product("Woman winter jacket", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 399.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), womanWinterJacket, "Blue"));
        listOfProducts.add(new Product("Woman skiing jacket", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 522.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(2), womanSkiingJacket, "Green"));
        listOfProducts.add(new Product("Man skiing jacket", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 532.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(3), menSkiingJacket, "Orange"));

        listOfProducts.add(new Product("Man coat", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 299.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(3), menCoat, "Gray"));
        listOfProducts.add(new Product("Woman coat", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 239.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(2), womanCoat, "Gray"));

        listOfProducts.add(new Product("Man wedding suit", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 239.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), manWedding, "Gray"));
        listOfProducts.add(new Product("Wedding gown", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 539.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), weddingGown, "White"));

        listOfProducts.add(new Product("Man hat", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 49.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(2), manHat, "White"));
        listOfProducts.add(new Product("Casual hat", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 30.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(3), casualHat, "Red"));
        listOfProducts.add(new Product("Stone Island Men Vintage Jacket", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 139.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), stoneJacket, "Gray"));
        listOfProducts.add(new Product("Vintage Women coat", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 151.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(2), vintageWoman, "Gray"));

        listOfProducts.add(new Product("Man Polo shirt", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 29.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), manPoloShirt, "Blue"));
        listOfProducts.add(new Product("Man pullover", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 39.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), manPullover, "Red"));

        listOfProducts.add(new Product("Swimming goggles", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 39.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), swimmingGlassesPhoto, "Blue"));

        listOfProducts.add(new Product("Bvlgari bag", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 1099.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), bvlgariBag, "Black"));
        listOfProducts.add(new Product("Gucci bag", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 1077.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), gucciBag, "White"));
        listOfProducts.add(new Product("Prada backpack", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 1600.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), pradaBackpack, "Black"));

        listOfProducts.add(new Product("Ray Ban sunglasses men", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 131.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), manRayBan, "Black"));
        listOfProducts.add(new Product("Aviator sunglasses men", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 129.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(2), manAviator, "Blue"));
        listOfProducts.add(new Product("Ray Ban sunglasses woman", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 129.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(3), womanRayBan, "Black"));
        listOfProducts.add(new Product("Tom Ford sunglasses woman", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 139.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), womanGuess, "Orange"));

        listOfProducts.add(new Product("Cloth mask", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 5.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), clothMask, "Black"));
        listOfProducts.add(new Product("Cloth bandana mask", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 9.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(2), clothBandana, "Blue"));

        listOfProducts.add(new Product("Engagement Ring", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 6999.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(3), engagementRing, "Silver"));
        listOfProducts.add(new Product("Silver bracelet", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 1199.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), silverBracelet, "Silver"));
        listOfProducts.add(new Product("Rosegold bracelet", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 1199.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), roseGoldBracelet, "Gold"));
        listOfProducts.add(new Product("Rosegold ring", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 699.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(2), rosegoldRing, "Gold"));
        listOfProducts.add(new Product("Silver ring", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 799.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(3), silverRing, "Silver"));

        listOfProducts.add(new Product("Body piercing", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 199.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), bodyPiercing, "Silver"));
        listOfProducts.add(new Product("Charm", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 199.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), charm, "Silver"));

        listOfProducts.add(new Product("Terrex man winter shoes", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 219.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(2), winterManShoes, "Black"));
        listOfProducts.add(new Product("Terrex woman winter shoes", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 199.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(3), womanWinterShoes, "Red"));
        listOfProducts.add(new Product("Terrex boy winter shoes", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 69.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), boyWinterShoes, "Green"));
        listOfProducts.add(new Product("Terrex girl winter shoes", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 69.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), girlWinterShoes, "Pink"));
        listOfProducts.add(new Product("Nike Court shoes", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 99.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(2), nikeCourt, "White"));
        listOfProducts.add(new Product("Nike Air Force shoes", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 139.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(3), nikeAirforce, "Green"));
        listOfProducts.add(new Product("Adidas Gazelle shoes", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 159.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), gazelle, "Black"));
        listOfProducts.add(new Product("Nike Jordan Women shoes", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 189.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), nikeWomanJordan, "Pink"));
        listOfProducts.add(new Product("Puma shoes", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 139.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(2), pumaShoes, "Black"));
        listOfProducts.add(new Product("Reebok Flexagon shoes", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 129.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(3), reebokShoes, "Blue"));

        listOfProducts.add(new Product("Black classy shoes", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 129.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), classyShoeMan, "Black"));
        listOfProducts.add(new Product("Blue classy shoes", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 129.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), classyBlueShoeMan, "Blue"));
        listOfProducts.add(new Product("Spotted heels", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 169.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(2), spottedHeels, "Black"));
        listOfProducts.add(new Product("Fashionable heels", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 169.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(3), feralHeals, "Blue"));
        listOfProducts.add(new Product("Nike summer shoes", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 119.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), summerManShoes, "White"));
        listOfProducts.add(new Product("Adidas summer shoes", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 119.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), summerWomanShoes, "Pink"));
        listOfProducts.add(new Product("Under Armour tank top", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 119.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(2), underArmourTankTop, "Black"));
        listOfProducts.add(new Product("Adidas training shirt", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 119.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(3), adidasTrainingShirt, "Gray"));

        listOfProducts.add(new Product("Adidas water bottle", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 19.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), gymWaterBottle, "Black"));
        listOfProducts.add(new Product("Fitness ball", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 39.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), fitnessBall, "Gray"));
        listOfProducts.add(new Product("Resistance band ", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 15.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(2), resistanceBand, "Yellow"));
        listOfProducts.add(new Product("White helmet", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 49.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(3), helmet, "White"));

        listOfProducts.add(new Product("Balcony furniture set", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 259.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), balconySet, "Black"));
        listOfProducts.add(new Product("Kitchen furniture set", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 444.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), kitchenSet, "White"));
        listOfProducts.add(new Product("Bath cover ", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 49.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(2), bathCover, "White"));
        listOfProducts.add(new Product("Kids room bed furniture", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 122.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(3), kidsRoomBed, "White"));

        listOfProducts.add(new Product("PC Ram 8GB DDR4 2600Mhz", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 19.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), ram, "Black"));
        listOfProducts.add(new Product("NVIDIA GeForce RTX 2090 graphics card", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 1100.00, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(1), rtx2080, "Black"));
        listOfProducts.add(new Product("Kaspersky antivirus software", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 49.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(2), kasperskySoftware, ""));
        listOfProducts.add(new Product("Gaming PC", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 1999.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(3), gamingPc, "Black"));
        listOfProducts.add(new Product("Living room furniture", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 122.99, new Date(), new Date("2020/12/21"), true, false, listOfUsers.get(0), livingRoomSet, "Blue"));


        listOfProducts.get(0).setSize("Large");
        listOfProducts.get(1).setSize("Medium");
        listOfProducts.get(2).setSize("Small");
        listOfProducts.get(3).setSize("Extra Large");
        listOfProducts.get(20).setSize("Medium");
        listOfProducts.get(21).setSize("Large");
        listOfProducts.get(22).setSize("Large");
        listOfProducts.get(23).setSize("Small");
        listOfProducts.get(32).setSize("Large");
        listOfProducts.get(33).setSize("Small");
        listOfProducts.get(34).setSize("Medium");
        listOfProducts.get(62).setSize("Large");
        listOfProducts.get(63).setSize("Medium");
        listOfProducts.get(64).setSize("Extra Large");
        listOfProducts.get(65).setSize("Medium");
        listOfProducts.get(66).setSize("Large");
        listOfProducts.get(67).setSize("Medium");
        listOfProducts.get(68).setSize("Small");
        listOfProducts.get(69).setSize("Small");
        listOfProducts.get(70).setSize("Small");
        listOfProducts.get(71).setSize("Large");
        listOfProducts.get(72).setSize("Medium");
        listOfProducts.get(73).setSize("Large");
        listOfProducts.get(74).setSize("Medium");
        listOfProducts.get(75).setSize("Large");
        listOfProducts.get(93).setSize("Large");
        listOfProducts.get(94).setSize("Medium");
        listOfProducts.get(95).setSize("Large");
        listOfProducts.get(96).setSize("Medium");
        listOfProducts.get(97).setSize("Medium");
        listOfProducts.get(98).setSize("Small");
        listOfProducts.get(99).setSize("Small");
        listOfProducts.get(100).setSize("Large");
        listOfProducts.get(101).setSize("Small");
        listOfProducts.get(102).setSize("Large");
        listOfProducts.get(103).setSize("Small");
        listOfProducts.get(104).setSize("Large");
        listOfProducts.get(105).setSize("Small");
        listOfProducts.get(106).setSize("Large");
        listOfProducts.get(107).setSize("Small");
        listOfProducts.get(108).setSize("Small");
        listOfProducts.get(109).setSize("Large");
        listOfProducts.get(110).setSize("Large");

        Set<Rating> ratingsBest = new HashSet<>();
        Set<Rating> ratingsVeryGood = new HashSet<>();
        Set<Rating> ratingsGood = new HashSet<>();
        Set<Rating> ratingsBad = new HashSet<>();
        Set<Rating> ratingsVeryBad = new HashSet<>();
        Rating bestRating = new Rating();
        bestRating.setRating(5);
        Rating veryGood = new Rating();
        veryGood.setRating(4);
        Rating good = new Rating();
        good.setRating(3);
        Rating bad = new Rating();
        bad.setRating(2);
        Rating veryBad = new Rating();
        veryBad.setRating(1);
        ratingsBest.add(bestRating);
        ratingsVeryGood.add(veryGood);
        ratingsGood.add(good);
        ratingsBad.add(bad);
        ratingsVeryBad.add(veryBad);

        listOfProducts.get(0).setRating(ratingsBest);
        listOfProducts.get(1).setRating(ratingsVeryGood);
        listOfProducts.get(2).setRating(ratingsGood);
        listOfProducts.get(3).setRating(ratingsBad);
        listOfProducts.get(4).setRating(ratingsBest);
        listOfProducts.get(5).setRating(ratingsVeryGood);
        listOfProducts.get(6).setRating(ratingsGood);
        listOfProducts.get(7).setRating(ratingsBad);
        listOfProducts.get(8).setRating(ratingsBest);
        listOfProducts.get(9).setRating(ratingsVeryGood);
        listOfProducts.get(10).setRating(ratingsGood);
        listOfProducts.get(11).setRating(ratingsBad);
        listOfProducts.get(12).setRating(ratingsBest);
        listOfProducts.get(13).setRating(ratingsVeryGood);
        listOfProducts.get(14).setRating(ratingsGood);
        listOfProducts.get(15).setRating(ratingsBad);
        listOfProducts.get(16).setRating(ratingsBest);
        listOfProducts.get(17).setRating(ratingsVeryGood);
        listOfProducts.get(18).setRating(ratingsGood);
        listOfProducts.get(19).setRating(ratingsBad);
        listOfProducts.get(20).setRating(ratingsBest);
        listOfProducts.get(21).setRating(ratingsVeryGood);
        listOfProducts.get(22).setRating(ratingsGood);
        listOfProducts.get(23).setRating(ratingsBad);
        listOfProducts.get(24).setRating(ratingsBest);
        listOfProducts.get(25).setRating(ratingsVeryGood);
        listOfProducts.get(26).setRating(ratingsGood);
        listOfProducts.get(27).setRating(ratingsBad);
        listOfProducts.get(28).setRating(ratingsBest);
        listOfProducts.get(29).setRating(ratingsVeryGood);
        listOfProducts.get(30).setRating(ratingsGood);
        listOfProducts.get(31).setRating(ratingsBad);
        listOfProducts.get(32).setRating(ratingsBest);
        listOfProducts.get(33).setRating(ratingsVeryGood);
        listOfProducts.get(34).setRating(ratingsGood);
        listOfProducts.get(35).setRating(ratingsBad);
        listOfProducts.get(36).setRating(ratingsBest);
        listOfProducts.get(37).setRating(ratingsVeryGood);
        listOfProducts.get(38).setRating(ratingsGood);
        listOfProducts.get(39).setRating(ratingsBad);
        listOfProducts.get(40).setRating(ratingsBest);
        listOfProducts.get(41).setRating(ratingsVeryGood);
        listOfProducts.get(42).setRating(ratingsGood);
        listOfProducts.get(43).setRating(ratingsBad);
        listOfProducts.get(44).setRating(ratingsBest);
        listOfProducts.get(45).setRating(ratingsVeryGood);
        listOfProducts.get(46).setRating(ratingsGood);
        listOfProducts.get(47).setRating(ratingsBad);
        listOfProducts.get(48).setRating(ratingsVeryGood);
        listOfProducts.get(49).setRating(ratingsBest);
        listOfProducts.get(50).setRating(ratingsVeryGood);
        listOfProducts.get(51).setRating(ratingsBest);
        listOfProducts.get(52).setRating(ratingsVeryGood);
        listOfProducts.get(53).setRating(ratingsBad);
        listOfProducts.get(54).setRating(ratingsBest);
        listOfProducts.get(55).setRating(ratingsVeryGood);
        listOfProducts.get(56).setRating(ratingsGood);
        listOfProducts.get(57).setRating(ratingsBest);
        listOfProducts.get(58).setRating(ratingsVeryGood);
        listOfProducts.get(59).setRating(ratingsBest);
        listOfProducts.get(60).setRating(ratingsBest);
        listOfProducts.get(61).setRating(ratingsVeryBad);
        listOfProducts.get(62).setRating(ratingsGood);
        listOfProducts.get(63).setRating(ratingsBest);
        listOfProducts.get(64).setRating(ratingsVeryGood);
        listOfProducts.get(65).setRating(ratingsGood);
        listOfProducts.get(66).setRating(ratingsBest);
        listOfProducts.get(67).setRating(ratingsVeryGood);
        listOfProducts.get(68).setRating(ratingsBest);
        listOfProducts.get(69).setRating(ratingsBest);
        listOfProducts.get(70).setRating(ratingsGood);
        listOfProducts.get(71).setRating(ratingsVeryGood);
        listOfProducts.get(72).setRating(ratingsBest);
        listOfProducts.get(73).setRating(ratingsVeryGood);
        listOfProducts.get(74).setRating(ratingsBest);
        listOfProducts.get(75).setRating(ratingsVeryGood);
        listOfProducts.get(76).setRating(ratingsBest);
        listOfProducts.get(77).setRating(ratingsVeryGood);
        listOfProducts.get(78).setRating(ratingsBest);
        listOfProducts.get(79).setRating(ratingsGood);
        listOfProducts.get(80).setRating(ratingsBest);
        listOfProducts.get(81).setRating(ratingsVeryGood);
        listOfProducts.get(82).setRating(ratingsBest);
        listOfProducts.get(83).setRating(ratingsVeryGood);
        listOfProducts.get(84).setRating(ratingsBest);
        listOfProducts.get(85).setRating(ratingsVeryGood);
        listOfProducts.get(86).setRating(ratingsBest);
        listOfProducts.get(87).setRating(ratingsVeryGood);
        listOfProducts.get(88).setRating(ratingsBest);
        listOfProducts.get(89).setRating(ratingsGood);
        listOfProducts.get(90).setRating(ratingsBest);
        listOfProducts.get(91).setRating(ratingsBest);
        listOfProducts.get(92).setRating(ratingsBest);
        listOfProducts.get(93).setRating(ratingsBest);
        listOfProducts.get(94).setRating(ratingsVeryGood);
        listOfProducts.get(94).setRating(ratingsVeryGood);
        listOfProducts.get(95).setRating(ratingsBest);
        listOfProducts.get(96).setRating(ratingsVeryGood);
        listOfProducts.get(97).setRating(ratingsBest);
        listOfProducts.get(98).setRating(ratingsBest);
        listOfProducts.get(99).setRating(ratingsBest);
        listOfProducts.get(100).setRating(ratingsVeryGood);
        listOfProducts.get(101).setRating(ratingsGood);
        listOfProducts.get(102).setRating(ratingsGood);
        listOfProducts.get(103).setRating(ratingsBest);
        listOfProducts.get(104).setRating(ratingsVeryGood);
        listOfProducts.get(105).setRating(ratingsBest);
        listOfProducts.get(106).setRating(ratingsVeryGood);
        listOfProducts.get(107).setRating(ratingsBest);
        listOfProducts.get(108).setRating(ratingsVeryGood);
        listOfProducts.get(109).setRating(ratingsBest);
        listOfProducts.get(110).setRating(ratingsVeryGood);
        listOfProducts.get(111).setRating(ratingsBest);
        listOfProducts.get(112).setRating(ratingsBest);
        listOfProducts.get(113).setRating(ratingsBest);
        listOfProducts.get(114).setRating(ratingsBest);
        listOfProducts.get(115).setRating(ratingsBest);
        listOfProducts.get(116).setRating(ratingsBest);
        listOfProducts.get(117).setRating(ratingsBest);
        listOfProducts.get(118).setRating(ratingsBest);
        listOfProducts.get(119).setRating(ratingsBest);
        listOfProducts.get(120).setRating(ratingsBest);
        listOfProducts.get(121).setRating(ratingsBest);
        listOfProducts.get(122).setRating(ratingsBest);
        listOfProducts.get(123).setRating(ratingsBest);


        listOfProducts.get(0).setSubcategory(runningShoesSub);
        listOfProducts.get(1).setSubcategory(runningShoesSub);
        listOfProducts.get(2).setSubcategory(runningShoesSub);
        listOfProducts.get(3).setSubcategory(runningShoesSub);
        listOfProducts.get(4).setSubcategory(phones);
        listOfProducts.get(5).setSubcategory(phones);
        listOfProducts.get(6).setSubcategory(phones);
        listOfProducts.get(7).setSubcategory(phones);
        listOfProducts.get(8).setSubcategory(laptops);
        listOfProducts.get(9).setSubcategory(laptops);
        listOfProducts.get(10).setSubcategory(laptops);
        listOfProducts.get(11).setSubcategory(laptops);
        listOfProducts.get(12).setSubcategory(tvs);
        listOfProducts.get(13).setSubcategory(tvs);
        listOfProducts.get(14).setSubcategory(tvs);
        listOfProducts.get(15).setSubcategory(tvs);
        listOfProducts.get(16).setSubcategory(watches);
        listOfProducts.get(17).setSubcategory(watches);
        listOfProducts.get(18).setSubcategory(watches);
        listOfProducts.get(19).setSubcategory(watches);
        listOfProducts.get(20).setSubcategory(necklaces);
        listOfProducts.get(21).setSubcategory(necklaces);
        listOfProducts.get(22).setSubcategory(necklaces);
        listOfProducts.get(23).setSubcategory(necklaces);
        listOfProducts.get(24).setSubcategory(womanTraining);
        listOfProducts.get(25).setSubcategory(menTraining);
        listOfProducts.get(26).setSubcategory(womanTraining);
        listOfProducts.get(27).setSubcategory(menTraining);
        listOfProducts.get(28).setSubcategory(bedroom);
        listOfProducts.get(29).setSubcategory(bedroom);
        listOfProducts.get(30).setSubcategory(bedroom);
        listOfProducts.get(31).setSubcategory(bedroom);
        listOfProducts.get(32).setSubcategory(kitchenElectronics);
        listOfProducts.get(33).setSubcategory(kitchenElectronics);
        listOfProducts.get(34).setSubcategory(kitchenElectronics);
        listOfProducts.get(35).setSubcategory(washingMachines);
        listOfProducts.get(36).setSubcategory(womanClothes);
        listOfProducts.get(37).setSubcategory(womanClothes);
        listOfProducts.get(38).setSubcategory(womanClothes);
        listOfProducts.get(39).setSubcategory(sunglassesSub);
        listOfProducts.get(40).setSubcategory(handTools);
        listOfProducts.get(41).setSubcategory(handTools);
        listOfProducts.get(42).setSubcategory(handTools);
        listOfProducts.get(43).setSubcategory(handTools);
        listOfProducts.get(44).setSubcategory(scifiBooks);
        listOfProducts.get(45).setSubcategory(scifiBooks);
        listOfProducts.get(46).setSubcategory(scifiBooks);
        listOfProducts.get(47).setSubcategory(scifiBooks);
        listOfProducts.get(48).setSubcategory(lamps);
        listOfProducts.get(49).setSubcategory(gamingConsole);
        listOfProducts.get(50).setSubcategory(gamingConsole);
        listOfProducts.get(51).setSubcategory(conditioning);
        listOfProducts.get(52).setSubcategory(cases);
        listOfProducts.get(53).setSubcategory(cases);
        listOfProducts.get(54).setSubcategory(chargers);
        listOfProducts.get(55).setSubcategory(chargers);
        listOfProducts.get(56).setSubcategory(chargers);
        listOfProducts.get(57).setSubcategory(headphones);
        listOfProducts.get(58).setSubcategory(headphones);
        listOfProducts.get(59).setSubcategory(memoryCards);
        listOfProducts.get(60).setSubcategory(screenProtectors);
        listOfProducts.get(61).setSubcategory(screenProtectors);
        listOfProducts.get(62).setSubcategory(winterClothes);
        listOfProducts.get(63).setSubcategory(winterClothes);
        listOfProducts.get(64).setSubcategory(winterClothes);
        listOfProducts.get(65).setSubcategory(winterClothes);
        listOfProducts.get(66).setSubcategory(coats);
        listOfProducts.get(67).setSubcategory(coats);
        listOfProducts.get(68).setSubcategory(wedding);
        listOfProducts.get(69).setSubcategory(wedding);
        listOfProducts.get(70).setSubcategory(hatsSubCategory);
        listOfProducts.get(71).setSubcategory(hatsSubCategory);
        listOfProducts.get(72).setSubcategory(vintage);
        listOfProducts.get(73).setSubcategory(vintage);
        listOfProducts.get(74).setSubcategory(manClothes);
        listOfProducts.get(75).setSubcategory(manClothes);
        listOfProducts.get(76).setSubcategory(swimmingGlasses);
        listOfProducts.get(77).setSubcategory(bags);
        listOfProducts.get(78).setSubcategory(bags);
        listOfProducts.get(79).setSubcategory(bags);
        listOfProducts.get(80).setSubcategory(sunglassesSub);
        listOfProducts.get(81).setSubcategory(sunglassesSub);
        listOfProducts.get(82).setSubcategory(sunglassesSub);
        listOfProducts.get(83).setSubcategory(sunglassesSub);
        listOfProducts.get(84).setSubcategory(masks);
        listOfProducts.get(85).setSubcategory(masks);
        listOfProducts.get(86).setSubcategory(weddingRings);
        listOfProducts.get(87).setSubcategory(bracelet);
        listOfProducts.get(88).setSubcategory(bracelet);
        listOfProducts.get(89).setSubcategory(rings);
        listOfProducts.get(90).setSubcategory(rings);
        listOfProducts.get(91).setSubcategory(bodyPierceing);
        listOfProducts.get(92).setSubcategory(charms);
        listOfProducts.get(93).setSubcategory(winterShoes);
        listOfProducts.get(94).setSubcategory(winterShoes);
        listOfProducts.get(95).setSubcategory(winterShoes);
        listOfProducts.get(96).setSubcategory(winterShoes);
        listOfProducts.get(97).setSubcategory(sneakers);
        listOfProducts.get(98).setSubcategory(sneakers);
        listOfProducts.get(99).setSubcategory(sneakers);
        listOfProducts.get(100).setSubcategory(sneakers);
        listOfProducts.get(101).setSubcategory(sneakers);
        listOfProducts.get(102).setSubcategory(sneakers);
        listOfProducts.get(103).setSubcategory(classyShoes);
        listOfProducts.get(104).setSubcategory(classyShoes);
        listOfProducts.get(105).setSubcategory(heels);
        listOfProducts.get(106).setSubcategory(heels);
        listOfProducts.get(107).setSubcategory(summerShoes);
        listOfProducts.get(108).setSubcategory(summerShoes);
        listOfProducts.get(109).setSubcategory(tankTops);
        listOfProducts.get(110).setSubcategory(menTraining);
        listOfProducts.get(111).setSubcategory(gymAccessories);
        listOfProducts.get(112).setSubcategory(gymAccessories);
        listOfProducts.get(113).setSubcategory(resistanceBands);
        listOfProducts.get(114).setSubcategory(headgear);
        listOfProducts.get(115).setSubcategory(balcony);
        listOfProducts.get(116).setSubcategory(kitchen);
        listOfProducts.get(117).setSubcategory(bathroom);
        listOfProducts.get(118).setSubcategory(kidsRoom);
        listOfProducts.get(119).setSubcategory(hardware);
        listOfProducts.get(120).setSubcategory(hardware);
        listOfProducts.get(121).setSubcategory(software);
        listOfProducts.get(122).setSubcategory(gamingComputers);
        listOfProducts.get(123).setSubcategory(livingRoom);
        if (productRepository.findByName(listOfProducts.get(0).getName()) == null) {
            productRepository.saveAll(listOfProducts);
        } else LOGGER.log(Level.WARNING, "The products are already seeded");
    }
}