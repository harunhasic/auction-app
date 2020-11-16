import React from 'react';
import { Route, Switch } from 'react-router-dom';
import GuestRoutes from './GuestRoutes';
import Login from '../Login/Login';
import Register from '../register/Register';
import LandingPage from '../LandingPage/LandingPage';
import Categories from '../categories/Categories';
import NotFound from '../notFound/NotFound';
import ProductPage from '../productPage/Product';

const UserRoutes = (props) => {
    return (
        <Switch>
            <GuestRoutes path="/login" {...props} component={Login} />
            <GuestRoutes path="/register" {...props} component={Register} />
            <Route exact path="/" render={() => <LandingPage {...props} />} />
            <Route path="/categories" render={() => <Categories {...props} />} />
            <Route path="/*/*/:id" render={() => <ProductPage {...props} />} />
            <Route component={NotFound} />
        </Switch>
    );
}

export default UserRoutes;