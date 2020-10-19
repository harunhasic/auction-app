import React, { useEffect, useState } from 'react';
import { withRouter } from 'react-router-dom';
import { useHistory } from 'react-router-dom';
import { home } from '../../utils/RedirectUrls';
import CategoryService from '../../Services/category-service'
import SubCategoryService from '../../Services/subcategory-service'
import '../../styles/categories/AllCategories.scss';

const categoryService = new CategoryService();
const subCategoryService = new SubCategoryService();

const AllCategories = ({ setBreadcrumb }) => {
    const history = useHistory();

    const [categories, setCategories] = useState([]);
    const [subCategories, setSubCategories] = useState([]);

    useEffect(() => {
        async function fethCategories() {
            try {
                setBreadcrumb("ALL CATEGORIES", [{ text: "HOME", href: { home } }, { text: "ALL CATEGORIES" }]);
                await categoryService.getCategories().then(response => {
                    setCategories(response.data);
                })
                await subCategoryService.getAllSubCategories().then(response => {
                    setSubCategories(response.data);
                })
            } catch (e) { }
        }
        fethCategories();
    }, [])


    console.log(subCategories);
    return (
        <div className="container-fluid">

            {categories.length !== 0 ?
                <div>
                    <div className="row">
                        <div className="col-md">
                            <h2>{categories[8].name}</h2>
                            <h5>Wedding</h5>
                            <h5>Clothes</h5>
                            <h5>Coats</h5>
                            <h5>Vintage</h5>
                            <h5>Retro</h5>
                            <h5>Modern</h5>
                        </div>
                        <div className="col-md">
                            <h2>{categories[3].name}</h2>
                            <h5>Watches</h5>
                            <h5>Sunglasses</h5>
                            <h5>Armbands</h5>
                            <h5>Wristbands</h5>
                            <h5>Hats</h5>
                            <h5>Bags</h5>
                        </div>
                        <div className="col-md">
                            <h2>{categories[4].name}</h2>
                            <h5>Necklaces</h5>
                            <h5>Rings</h5>
                            <h5>Earrings</h5>
                            <h5>Hairpin</h5>
                            <h5>Bracelet</h5>
                            <h5>Body Piercing</h5>
                        </div>
                        <div className="col-md">
                            <h2>{categories[0].name}</h2>
                            <h5>Casual shoes</h5>
                            <h5>Running shoes</h5>
                            <h5>Hiking shoes</h5>
                            <h5>Winter boots</h5>
                            <h5>Classy shoes</h5>
                            <h5>Summer shoes</h5>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col-md">
                            <h2>{categories[5].name}</h2>
                            <h5>Sport shorts</h5>
                            <h5>Training clothes</h5>
                            <h5>Tank tops</h5>
                            <h5>Gym accessories</h5>
                            <h5>Hijabi sportwear</h5>
                            <h5>Women clothes</h5>
                        </div>
                        <div className="col-md">
                            <h2>{categories[6].name}</h2>
                            <h5>Bad and Bath</h5>
                            <h5>Bedroom</h5>
                            <h5>Kitchen</h5>
                            <h5>Living room</h5>
                            <h5>Kids room</h5>
                            <h5>Balcony</h5>
                        </div>
                        <div className="col-md">
                            <h2>{categories[7].name}</h2>
                            <h5>Utility electronics</h5>
                            <h5>TVs</h5>
                            <h5>Lamps</h5>
                            <h5>Gaming consoles</h5>
                            <h5>Washing machines</h5>
                            <h5>Air conditioning</h5>
                        </div>
                        <div className="col-md">
                            <h2>{categories[1].name}</h2>
                            <h5>Phones</h5>
                            <h5>Chargers</h5>
                            <h5>Headphones</h5>
                            <h5>Masks</h5>
                            <h5>Cases</h5>
                            <h5>Screen protectors</h5>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col-md">
                            <h2>{categories[2].name}</h2>
                            <h5>Laptops</h5>
                            <h5>Gaming computers</h5>
                            <h5>Office computers</h5>
                            <h5>Hardware</h5>
                            <h5>Software</h5>
                            <h5>Monitors</h5>
                        </div>
                        <div className="col-md">
                            <h2>{categories[9].name}</h2>
                            <h5>Drills</h5>
                            <h5>Wrenches</h5>
                            <h5>Measuring tapes</h5>
                            <h5>Hand tools</h5>
                            <h5>Knives</h5>
                            <h5>Screwdrivers</h5>
                        </div>
                        <div className="col-md">
                            <h2>{categories[10].name}</h2>
                            <h5>Children books</h5>
                            <h5>Motivational books</h5>
                            <h5>SCIFI books</h5>
                            <h5>Romance books</h5>
                            <h5>Cook books</h5>
                            <h5></h5>
                        </div>
                        <div className="col-md"></div>
                    </div>
                </div> : null}
        </div>
    );
}

export default withRouter(AllCategories);