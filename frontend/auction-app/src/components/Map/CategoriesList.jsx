import React from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import '../../styles/categories/CategoriesList.scss';

const CategoriesList = ({ category, setBreadcrumb }) => {

return (
    <React.Fragment>
        <Container className="categories-list-container">
            <Row >
                <Col className="category-list-name">{category.name}
                    {
                        category.subcategories.map(subcategory => (
                            <Col className="subcategory-name" key={subcategory.id} >{subcategory.name}</Col>
                        ))
                    }
                </Col>
            </Row>
        </Container>
    </React.Fragment>

    );
}

export default CategoriesList;