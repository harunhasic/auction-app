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

        SubCategory subcategory1 = new SubCategory("Wedding", fashion);
        subcategory1.setPhotoUrl("https://i.insider.com/5f32f8e83ad86149ec464bc3?width=1100&format=jpeg&auto=webp");
        SubCategory subcategory2 = new SubCategory("Woman clothes", fashion);
        subcategory2.setPhotoUrl("https://images.unsplash.com/photo-1512436991641-6745cdb1723f?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjEyMDd9");
        SubCategory subcategory12 = new SubCategory("Coats", fashion);
        subcategory12.setPhotoUrl("https://ae01.alicdn.com/kf/HTB1VizEXcrrK1RjSspaq6AREXXaI/Coats-Man-Winter-2018-Korean-Mens-Double-Breasted-Jacket-Coat-Slim-Fit-Wool-Trench-Coat-Men.jpg_q50.jpg");
        SubCategory subcategory13 = new SubCategory("Vintage", fashion);
        subcategory13.setPhotoUrl("https://sammydvintage.com/wp-content/uploads/2012/10/40s-clothes-pussycat-blouses.jpg");
        SubCategory subcategory14 = new SubCategory("Man Clothes", fashion);
        subcategory14.setPhotoUrl("https://i.pinimg.com/originals/13/ec/0a/13ec0a8cedb648a8d547261808032dad.jpg");
        SubCategory subcategory4 = new SubCategory("Winter clothes", fashion);
        subcategory4.setPhotoUrl("https://images-na.ssl-images-amazon.com/images/I/611I4RQj1zL._AC_UX385_.jpg");
        SubCategory subcategory8 = new SubCategory("Watches", accessories);
        subcategory8.setPhotoUrl("https://preview.redd.it/zfegrkerlk031.jpg?width=960&crop=smart&auto=webp&s=77f929c834026b75567d63acce85c65e611765d2");
        SubCategory subcategory15 = new SubCategory("Sunglasses", accessories);
        subcategory15.setPhotoUrl("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/sunglasses-copy-1596831360.jpg");
        SubCategory subcategory16 = new SubCategory("Swimming glasses", accessories);
        subcategory16.setPhotoUrl("https://image.made-in-china.com/2f0j00zQkfVoZhVWga/Big-Frame-Swimming-Goggles-Swim-Glasses-with-Customized-Logo.jpg");
        SubCategory subcategory17 = new SubCategory("Wristbands", accessories);
        subcategory17.setPhotoUrl("https://www.siliconewristbandsdirect.co.uk/wp-content/uploads/2018/08/Embossed-Silicone-Wristband-4.png");
        SubCategory subcategory18 = new SubCategory("Hats", accessories);
        subcategory18.setPhotoUrl("https://media.gq.com/photos/5a04f9a398002d2e253679f5/master/pass/fall-hats-gq-style-0816-01-1.jpg");
        SubCategory subcategory19 = new SubCategory("Bags", accessories);
        subcategory19.setPhotoUrl("https://shotkit.com/wp-content/uploads/2017/09/Best-camera-bags-in-2018.jpg");
        SubCategory subcategory9 = new SubCategory("Necklaces", jewelery);
        subcategory9.setPhotoUrl("https://marianilsdotter.com/wp-content/uploads/2020/05/categorypage-necklaces-mobile.jpg");
        SubCategory subCategory10 = new SubCategory("Wedding rings", jewelery);
        subCategory10.setPhotoUrl("https://www.tacori.com/media/gene-cms/e/n/engagementring-foundersring_d.jpg");
        SubCategory subCategory21 = new SubCategory("Rings", jewelery);
        subCategory21.setPhotoUrl("https://cdn.caratlane.com/media/catalog/product/cache/6/image/480x480/9df78eab33525d08d6e5fb8d27136e95//J/R/JR03980-YGP900_11_listfront.jpg");
        SubCategory subCategory22 = new SubCategory("Hairpin", jewelery);
        subCategory22.setPhotoUrl("https://images-na.ssl-images-amazon.com/images/I/61R4RPG-6VL._SL1024_.jpg");
        SubCategory subCategory23 = new SubCategory("Bracelet", jewelery);
        subCategory23.setPhotoUrl("https://stewartdawsons-co-nz.imgix.net/category/0908598001568258595~1568258596.jpg?w=1310&h=655&fit=crop&auto=format&q=60&s=0982a63914f9191b7e31b455ab6bf243");
        SubCategory subCategory24 = new SubCategory("Body piercing", jewelery);
        subCategory24.setPhotoUrl("https://cdn.shopify.com/s/files/1/2065/1597/articles/body-piercing-jewelry-pierced-mississauga_287_874106b3-4b77-4bbd-ac58-97e4cf1b3a60_1200x630.jpg?v=1594148533");
        SubCategory subcategory5 = new SubCategory("Casual shoes", shoes);
        subcategory5.setPhotoUrl("https://images-na.ssl-images-amazon.com/images/I/61QFvgXbH9L._UL1200_.jpg");
        SubCategory subcategory11 = new SubCategory("Running shoes", shoes);
        subcategory11.setPhotoUrl("https://www.saucony.com/on/demandware.static/-/Sites-saucony_us-Library/default/dwb7a76b30/content/seasonal-content/homepage/2020/10/home-main-trending-20201001-prinkshop-mens-d.jpg");
        SubCategory subcategory25 = new SubCategory("Hiking shoes", shoes);
        subcategory25.setPhotoUrl("https://www.switchbacktravel.com/sites/default/files/image_fields/Best%20Of%20Gear%20Articles/Hiking%20and%20Backpacking/Hiking%20Shoes/Salomon%20X%20Ultra%203%20GTX%20Low%20hiking%20shoe.jpg");
        SubCategory subcategory26 = new SubCategory("Winter shoes", shoes);
        subcategory26.setPhotoUrl("https://cdn.myshoptet.com/usr/www.loap.eu/user/shop/big/20120-3_loap-primosa-women-s-winter-shoes-beige-brown-hsl19205c03r.jpg?5f067b28");
        SubCategory subcategory27 = new SubCategory("Classy shoes", shoes);
        subcategory27.setPhotoUrl("https://i.pinimg.com/originals/7b/19/ec/7b19ec1c85423013362cbc4ff580cc0f.jpg");
        SubCategory subcategory28 = new SubCategory("Summer shoes", shoes);
        subcategory28.setPhotoUrl("https://footwearnews.com/wp-content/uploads/2018/04/castaner-summer-shoes-blue-background.jpg?w=1024");
        SubCategory subcategory20 = new SubCategory("Sport shorts", sportware);
        subcategory20.setPhotoUrl("https://www.wigglestatic.com/product-media/104069067/adidas-Must-Have-BOS-Short-Shorts-Black-White-SS20-DX7662S-8.jpg?w=430&h=430&a=7");
        SubCategory subcategory29 = new SubCategory("Training clothes", sportware);
        subcategory29.setPhotoUrl("https://ae01.alicdn.com/kf/H9ee1ae499a3441bea2f3c3295c79da97f/Running-Training-Clothes-Men-7PCS-SETS-Compression-Running-Sets-Basketball-Jogging-Tights-Underwear-Set-Gym-Fitness.jpg_960x960.jpg");
        SubCategory subcategory30 = new SubCategory("Tank tops", sportware);
        subcategory30.setPhotoUrl("https://ae01.alicdn.com/kf/Ha9be6321825c44e49ecc67434ddab799u.jpg?smt_ispass_5508316");
        SubCategory subcategory31 = new SubCategory("Gym accessories", sportware);
        subcategory31.setPhotoUrl("https://images-na.ssl-images-amazon.com/images/I/71F4QaVtFHL.jpg");
        SubCategory subcategory32 = new SubCategory("Women clothes", sportware);
        subcategory32.setPhotoUrl("https://ae01.alicdn.com/kf/H6ddd5bcea89c4071812deea49b4e9ec39/Women-Yoga-Sets-Five-piece-5-Set-Female-Clothing-Sets-Gym-Clothes-for-Women-Sportswear-Sports.jpg");
        SubCategory subcategory33 = new SubCategory("Hijabi sportwear", sportware);
        subcategory33.setPhotoUrl("https://i.pinimg.com/originals/73/d4/17/73d417f127910a9e10e7f76822eae207.jpg");
        SubCategory subcategory3 = new SubCategory("Bathroom", home);
        subcategory3.setPhotoUrl("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/colorful-bathrooms-heidi-caillier-design-seattle-interior-designer-bathroom-pink-zellige-tile-scaled-1584654087.jpg");
        SubCategory subcategory34 = new SubCategory("Bedroom", home);
        subcategory34.setPhotoUrl("https://www.yankodesign.com/images/design_news/2020/06/bedroom-designs/07-bedroom-Designs_Natural-Lighting_Berlin-HOuse.jpg");
        SubCategory subcategory35 = new SubCategory("Kitchen", home);
        subcategory35.setPhotoUrl("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/kitchen-ideas-hbx100119inspoindex-029-1572548599.jpg");
        SubCategory subcategory36 = new SubCategory("Living room", home);
        subcategory36.setPhotoUrl("https://images.unsplash.com/photo-1583847268964-b28dc8f51f92?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
        SubCategory subcategory37 = new SubCategory("Kids room", home);
        subcategory37.setPhotoUrl("https://media.architecturaldigest.com/photos/574f51cc1cd9644b0beb1e6a/master/pass/KinderModern-high-design-kids-room_02.jpg");
        SubCategory subcategory38 = new SubCategory("Balcony", home);
        subcategory38.setPhotoUrl("https://cdn.decoist.com/wp-content/uploads/2019/09/Dash-of-timeless-NYC-charm-for-the-tiny-balcony-next-to-the-bedroom.jpg");
        SubCategory subCategory39 = new SubCategory("Kitchen electronics", electronics);
        subCategory39.setPhotoUrl("https://mydecorative.com/wp-content/uploads/2019/05/new-refrigerator.jpg");
        SubCategory subCategory40 = new SubCategory("TVs", electronics);
        subCategory40.setPhotoUrl("https://iqmobile.ba/wp-content/uploads/2019/10/32incha.png");
        SubCategory subCategory41 = new SubCategory("Lamps", electronics);
        subCategory41.setPhotoUrl("https://assets.pbimgs.com/pbimgs/ab/images/dp/wcm/202021/0028/faris-ceramic-table-lamp-base-c.jpg");
        SubCategory subCategory42 = new SubCategory("Gaming consoles", electronics);
        subCategory42.setPhotoUrl("https://miro.medium.com/max/3696/0*UqnTgDYpNqtEJrsC.jpg");
        SubCategory subCategory43 = new SubCategory("Washing machines", electronics);
        subCategory43.setPhotoUrl("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/gh-best-washing-machines-1589999096.png");
        SubCategory subCategory44 = new SubCategory("Air conditioning", electronics);
        subCategory44.setPhotoUrl("https://merculexenergy.com/wp-content/uploads/2020/05/smart-ac.jpg");
        SubCategory subcategory6 = new SubCategory("Phones", mobile);
        subcategory6.setPhotoUrl("https://cdn.pocket-lint.com/r/s/1200x/assets/images/120309-phones-buyer-s-guide-best-smartphones-2020-the-top-mobile-phones-available-to-buy-today-image1-eagx1ykift.jpg");
        SubCategory subcategory45 = new SubCategory("Chargers", mobile);
        subcategory45.setPhotoUrl("https://cdn.shopify.com/s/files/1/0107/9030/5892/products/Samsung-2-1A-Wall-Charger-SDL472017473-1-6d413_62646787-703d-4ea6-b686-e158d0042da5_838x.jpeg?v=1588158546");
        SubCategory subcategory46 = new SubCategory("Headphones", mobile);
        subcategory46.setPhotoUrl("https://images.unsplash.com/photo-1505740420928-5e560c06d30e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
        SubCategory subcategory47 = new SubCategory("Memory cards", mobile);
        subcategory47.setPhotoUrl("https://upload.wikimedia.org/wikipedia/commons/0/0b/Memory-card-comparison.jpg");
        SubCategory subcategory48 = new SubCategory("Cases", mobile);
        subcategory48.setPhotoUrl("https://images-na.ssl-images-amazon.com/images/I/61rMFuu5sFL._SL1500_.jpg");
        SubCategory subcategory49 = new SubCategory("Screen protectors", mobile);
        subcategory49.setPhotoUrl("https://cdnblob.moshi.com/uploadedfiles/photo/v3/productImages/1065/01.jpg");
        SubCategory subcategory7 = new SubCategory("Laptops", computer);
        subcategory7.setPhotoUrl("https://cdn.mos.cms.futurecdn.net/X5TyA8uvkGXoNyjFzxcowS.jpg");
        SubCategory subcategory50 = new SubCategory("Gaming computers", computer);
        subcategory50.setPhotoUrl("https://media.wired.com/photos/5ed56dac0164ade5f2950d7f/master/pass/Gear-Buying-Guide-HP-Omen-Desktop-SOURCE-HP.jpg");
        SubCategory subcategory51 = new SubCategory("Office computers", computer);
        subcategory51.setPhotoUrl("https://i.pcmag.com/imagery/reviews/04xTDKsqdUzgKvWI7MGVnG3-1..1598204639.jpg");
        SubCategory subcategory52 = new SubCategory("Hardware", computer);
        subcategory52.setPhotoUrl("https://cdn.wccftech.com/wp-content/uploads/2020/06/NVIDIA-RTX-3080-3D-Feature-2.jpg");
        SubCategory subcategory53 = new SubCategory("Software", computer);
        subcategory53.setPhotoUrl("https://chiefexecutive.net/wp-content/uploads/2018/11/AdobeStock_92323963-compressor-1024x662.jpeg");
        SubCategory subcategory54 = new SubCategory("Monitors", computer);
        subcategory54.setPhotoUrl("https://9to5mac.com/wp-content/uploads/sites/6/2019/05/LG-UltraFine-4K-Display-Review-9to5mac.jpg?quality=82&strip=all&w=1600");
        SubCategory subcategory55 = new SubCategory("Drills", tools);
        subcategory55.setPhotoUrl("https://media.4rgos.it/i/Argos/8260385_R_Z001A?w=750&h=440&qlt=70");
        SubCategory subcategory56 = new SubCategory("Wrenches", tools);
        subcategory56.setPhotoUrl("https://img.lovepik.com/photo/50007/8945.jpg_wh860.jpg");
        SubCategory subcategory57 = new SubCategory("Measuring tapes", tools);
        subcategory57.setPhotoUrl("https://5.imimg.com/data5/DX/IO/MY-17043459/fiber-glass-measuring-tapes-500x500.jpg");
        SubCategory subcategory58 = new SubCategory("Hand tools", tools);
        subcategory58.setPhotoUrl("https://cdn1.vectorstock.com/i/1000x1000/89/80/modern-hand-tools-instruments-collection-vector-2148980.jpg");
        SubCategory subcategory59 = new SubCategory("Knives", tools);
        subcategory59.setPhotoUrl("https://cdn1.fnsharp.com/wp-content/uploads/2019/08/types-of-kitchen-knives.jpeg");
        SubCategory subcategory60 = new SubCategory("Screwdrivers", tools);
        subcategory60.setPhotoUrl("https://s3-production.bobvila.com/articles/wp-content/uploads/2017/04/Types_Of_Screwdrivers.jpg");
        SubCategory subCategory61 = new SubCategory("Children books", books);
        subCategory61.setPhotoUrl("https://images-na.ssl-images-amazon.com/images/I/71IRyc2IB0L.jpg");
        SubCategory subCategory62 = new SubCategory("Motivational books", books);
        subCategory62.setPhotoUrl("https://thestrive.co/wp-content/uploads/2019/03/Best-Motivational-Books.png");
        SubCategory subCategory63 = new SubCategory("SCIFI books", books);
        subCategory63.setPhotoUrl("https://media.wired.com/photos/5be4cd03db23f3775e466767/125:94/w_2375,h_1786,c_limit/books-521812297.jpg");
        SubCategory subCategory64 = new SubCategory("Romance books", books);
        subCategory64.setPhotoUrl("https://media.glamour.com/photos/5d31c84e613e440008564e91/master/w_1661,h_2560,c_limit/04-books.jpg");
        SubCategory subCategory65 = new SubCategory("Cook books", books);
        subCategory65.setPhotoUrl("https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimg1.cookinglight.timeinc.net%2Fsites%2Fdefault%2Ffiles%2Fstyles%2Fmedium_2x%2Fpublic%2Fupdated_main_images%2F1111p131-best-general-cookbooks-x.jpg%3Fitok%3Dbk-t2871");
        SubCategory subCategory66 = new SubCategory("DIY Books", books);
        subCategory66.setPhotoUrl("https://images-na.ssl-images-amazon.com/images/I/81SUyqPkpTL.jpg");

        setOfSubcategories.add(subcategory1);
        setOfSubcategories.add(subcategory2);
        setOfSubcategories.add(subcategory3);
        setOfSubcategories.add(subcategory4);
        setOfSubcategories.add(subcategory5);
        setOfSubcategories.add(subcategory6);
        setOfSubcategories.add(subcategory7);
        setOfSubcategories.add(subcategory8);
        setOfSubcategories.add(subcategory8);
        setOfSubcategories.add(subcategory9);
        setOfSubcategories.add(subCategory10);
        setOfSubcategories.add(subcategory11);
        setOfSubcategories.add(subcategory12);
        setOfSubcategories.add(subcategory13);
        setOfSubcategories.add(subcategory14);
        setOfSubcategories.add(subcategory15);
        setOfSubcategories.add(subcategory16);
        setOfSubcategories.add(subcategory17);
        setOfSubcategories.add(subcategory18);
        setOfSubcategories.add(subcategory19);
        setOfSubcategories.add(subcategory20);
        setOfSubcategories.add(subCategory21);
        setOfSubcategories.add(subCategory22);
        setOfSubcategories.add(subCategory23);
        setOfSubcategories.add(subCategory24);
        setOfSubcategories.add(subcategory25);
        setOfSubcategories.add(subcategory26);
        setOfSubcategories.add(subcategory27);
        setOfSubcategories.add(subcategory28);
        setOfSubcategories.add(subcategory29);
        setOfSubcategories.add(subcategory30);
        setOfSubcategories.add(subcategory31);
        setOfSubcategories.add(subcategory32);
        setOfSubcategories.add(subcategory33);
        setOfSubcategories.add(subcategory34);
        setOfSubcategories.add(subcategory35);
        setOfSubcategories.add(subcategory36);
        setOfSubcategories.add(subcategory37);
        setOfSubcategories.add(subcategory38);
        setOfSubcategories.add(subCategory39);
        setOfSubcategories.add(subCategory40);
        setOfSubcategories.add(subCategory41);
        setOfSubcategories.add(subCategory42);
        setOfSubcategories.add(subCategory43);
        setOfSubcategories.add(subCategory44);
        setOfSubcategories.add(subcategory45);
        setOfSubcategories.add(subcategory46);
        setOfSubcategories.add(subcategory47);
        setOfSubcategories.add(subcategory48);
        setOfSubcategories.add(subcategory49);
        setOfSubcategories.add(subcategory50);
        setOfSubcategories.add(subcategory51);
        setOfSubcategories.add(subcategory52);
        setOfSubcategories.add(subcategory53);
        setOfSubcategories.add(subcategory54);
        setOfSubcategories.add(subcategory55);
        setOfSubcategories.add(subcategory56);
        setOfSubcategories.add(subcategory57);
        setOfSubcategories.add(subcategory58);
        setOfSubcategories.add(subcategory59);
        setOfSubcategories.add(subcategory60);
        setOfSubcategories.add(subCategory61);
        setOfSubcategories.add(subCategory62);
        setOfSubcategories.add(subCategory63);
        setOfSubcategories.add(subCategory64);
        setOfSubcategories.add(subCategory65);
        setOfSubcategories.add(subCategory66);

        if (subCategoryRepository.findByName(subcategory1.getName()) == null) {
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
        listOfUsers.get(1).setAddress(listOfAddresses.get(1));
        listOfUsers.get(2).setAddress(listOfAddresses.get(2));
        listOfUsers.get(3).setAddress(listOfAddresses.get(3));
        if (userRepository.findByName(listOfUsers.get(0).getFirstName()) == null) {
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

        listOfProducts.add(new Product("Unisex running Shoes", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero. ", 240.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(0), runningShoes));
        listOfProducts.add(new Product("Nike running shoes", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 110.00, new Date(), new Date("2019/12/23"), true, false, listOfUsers.get(3), runningShoes2));
        listOfProducts.add(new Product("Adidas running shoes", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 110.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(1), runningShoes3));
        listOfProducts.add(new Product("Under armour shoes", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 110.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(1), runningShoes4));

        listOfProducts.add(new Product("Apple iPhone 11 Pro Max", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero. ", 1999.00, new Date(), new Date("2020/12/16 13:55:12"), true, false, listOfUsers.get(3), iPhone11Pro));
        listOfProducts.add(new Product("Apple iPhone X 64GB", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero. ", 1099.99, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(1), iPhoneX));
        listOfProducts.add(new Product("Apple iPhone XR", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero. ", 900.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(0), iPhoneXr));
        listOfProducts.add(new Product("Samsung Galaxy S20″", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero. ", 1440.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(1), s20));

        listOfProducts.add(new Product("HP ProBook G7", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero. ", 1299.95, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(0), hpG7));
        listOfProducts.add(new Product("MacBook Pro 13” ", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 2779.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(1), macbookPro));
        listOfProducts.add(new Product("Lenovo ThinkPad” ", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 1779.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(1), lenovo));
        listOfProducts.add(new Product("Dell XPS” ", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 1999.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(1), dell));

        listOfProducts.add(new Product("Tissot V8", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 4550.99, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(2), tissot));
        listOfProducts.add(new Product("Mens Rolex Submariner", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 10999.99, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(0), rolex));
        listOfProducts.add(new Product("Tag Heuer Carrera", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 4525.99, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(0), tagheuer));
        listOfProducts.add(new Product("Omega Speedmaster", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 9000.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(1), omega));

        listOfProducts.add(new Product("Golden necklace.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 1110.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(2), goldenNecklace));
        listOfProducts.add(new Product("Gold pendant", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 1120.00, new Date(), new Date("2020/12/01"), true, false, listOfUsers.get(0), goldenPendant));
        listOfProducts.add(new Product("Rose gold pendant", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 1120.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(1), rosePendant));
        listOfProducts.add(new Product("Diamond vine", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 1120.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(2), diamondVine));

        listOfProducts.add(new Product("Womans tracksuit", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 110.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(3), womansTracksuit));
        listOfProducts.add(new Product("Mens tracksuit", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 110.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(0), mensTracksuit));
        listOfProducts.add(new Product("Womans yoga pants", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 110.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(1), womenYoga));
        listOfProducts.add(new Product("Mens shorts", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 110.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(2), menShorts));

        listOfProducts.add(new Product("Single bed", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 410.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(0), bed));
        listOfProducts.add(new Product("King size bed", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 810.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(3), kingsize));
        listOfProducts.add(new Product("Bed cover", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 90.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(2), cover));
        listOfProducts.add(new Product("Bunk bed", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 560.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(1), bunkbed));

        listOfProducts.add(new Product("Built in oven", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 699.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(1), builtInOven));
        listOfProducts.add(new Product("Microwave", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 249.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(2), microwave));
        listOfProducts.add(new Product("Dishwasher", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 499.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(0), dishwasher));
        listOfProducts.add(new Product("Washing machine", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 599.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(1), washingMachine));

        listOfProducts.add(new Product("Suit", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 250.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(0), suit));
        listOfProducts.add(new Product("Woman dress", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 150.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(2), dress));
        listOfProducts.add(new Product("Hats", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 110.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(1), hats));
        listOfProducts.add(new Product("Sunglasses", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 149.99, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(3), sunglasses));

        listOfProducts.add(new Product("Hammer", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 49.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(3), hammer));
        listOfProducts.add(new Product("Cutter", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 49.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(2), cutter));
        listOfProducts.add(new Product("Axe", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 39.99, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(1), axe));
        listOfProducts.add(new Product("Saw", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 39.99, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(0), saw));

        listOfProducts.add(new Product("Harry Potter", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 60.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(2), harryPotter));
        listOfProducts.add(new Product("The Godfather", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 60.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(3), theGodfather));
        listOfProducts.add(new Product("The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 60.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(1), lotr));
        listOfProducts.add(new Product("Hyperion", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ut consequat nulla. Duis nec fermentum erat, et varius augue. Vivamus sed tempor libero.", 60.00, new Date(), new Date("2020/11/20"), true, false, listOfUsers.get(0), hyperion));


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


        listOfProducts.get(0).setSubcategory(subcategory11);

        listOfProducts.get(1).setSubcategory(subcategory11);
        listOfProducts.get(2).setSubcategory(subcategory11);

        listOfProducts.get(3).setSubcategory(subcategory11);

        listOfProducts.get(4).setSubcategory(subcategory6);

        listOfProducts.get(5).setSubcategory(subcategory6);

        listOfProducts.get(6).setSubcategory(subcategory6);

        listOfProducts.get(7).setSubcategory(subcategory6);

        listOfProducts.get(8).setSubcategory(subcategory7);

        listOfProducts.get(9).setSubcategory(subcategory7);

        listOfProducts.get(10).setSubcategory(subcategory7);

        listOfProducts.get(11).setSubcategory(subcategory7);

        listOfProducts.get(12).setSubcategory(subcategory8);

        listOfProducts.get(13).setSubcategory(subcategory8);

        listOfProducts.get(14).setSubcategory(subcategory8);

        listOfProducts.get(15).setSubcategory(subcategory8);

        listOfProducts.get(16).setSubcategory(subcategory9);

        listOfProducts.get(17).setSubcategory(subcategory9);

        listOfProducts.get(18).setSubcategory(subcategory9);

        listOfProducts.get(19).setSubcategory(subcategory9);

        listOfProducts.get(20).setSubcategory(subcategory29);

        listOfProducts.get(21).setSubcategory(subcategory29);

        listOfProducts.get(22).setSubcategory(subcategory29);

        listOfProducts.get(23).setSubcategory(subcategory29);

        listOfProducts.get(24).setSubcategory(subcategory34);

        listOfProducts.get(25).setSubcategory(subcategory34);

        listOfProducts.get(26).setSubcategory(subcategory34);

        listOfProducts.get(27).setSubcategory(subcategory34);

        listOfProducts.get(28).setSubcategory(subCategory39);

        listOfProducts.get(29).setSubcategory(subCategory39);

        listOfProducts.get(30).setSubcategory(subCategory39);

        listOfProducts.get(31).setSubcategory(subCategory39);

        listOfProducts.get(32).setSubcategory(subcategory2);

        listOfProducts.get(33).setSubcategory(subcategory2);

        listOfProducts.get(34).setSubcategory(subcategory2);

        listOfProducts.get(35).setSubcategory(subcategory2);

        listOfProducts.get(36).setSubcategory(subcategory58);

        listOfProducts.get(37).setSubcategory(subcategory58);

        listOfProducts.get(38).setSubcategory(subcategory58);

        listOfProducts.get(39).setSubcategory(subcategory58);

        listOfProducts.get(40).setSubcategory(subCategory63);

        listOfProducts.get(41).setSubcategory(subCategory63);

        listOfProducts.get(42).setSubcategory(subCategory63);

        listOfProducts.get(43).setSubcategory(subCategory63);
        if (productRepository.findByName(listOfProducts.get(0).getName()) == null) {
            productRepository.saveAll(listOfProducts);
        } else LOGGER.log(Level.WARNING, "The products are already seeded");
    }
}