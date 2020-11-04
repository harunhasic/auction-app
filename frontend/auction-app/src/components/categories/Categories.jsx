import React, { useEffect, useState } from 'react';
import { withRouter } from 'react-router-dom';
import { useHistory } from 'react-router-dom';
import { home } from '../../utils/RedirectUrls';
import CategoryService from '../../Services/category-service'
import SubCategoryService from '../../Services/subcategory-service'
import '../../styles/categories/AllCategories.scss';
import CategoriesList from '../Map/CategoriesList';
import ErrorComponent from '../notFound/ErrorComponent';

const categoryService = new CategoryService();

const AllCategories = ({ setBreadcrumb }) => {
    const history = useHistory();

    const [categories, setCategories] = useState([]);
    const [hasError, setHasError] = useState(false);

    useEffect(() => {
        async function fethCategories() {
            try {
                setBreadcrumb("ALL CATEGORIES", [{ text: "HOME", href: { home } }, { text: "ALL CATEGORIES" }]);
                await categoryService.getCategories().then(response => {
                    setCategories(response.data);
                })
            } catch (e) {
                setHasError(true);
            }
        }
        fethCategories();
    }, [])

    return (
        <React.Fragment>
            {categories.length !== 0 ?
                <div className="row">
                    {
                     categories.map(category => (
                        <CategoriesList key={category.id} category={category} />
                     ))
                    }
                </div> : <ErrorComponent></ErrorComponent>}
        </React.Fragment>
    );
}

export default withRouter(AllCategories);