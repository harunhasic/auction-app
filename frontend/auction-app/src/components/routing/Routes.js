import React from 'react';
import { Route, Switch } from 'react-router-dom';
import GuestRoutes from './GuestRoutes';
import PrivateRoute from './PrivateRoute';
import Login from '../Login/Login';
import Register from '../register/Register';
import LandingPage from '../LandingPage/LandingPage';
import Categories from '../categories/Categories';
import NotFound from '../notFound/NotFound';
import Shop from '../shop/Shop';
import Profile from '../MyProfile/Profile';
import ProductPage from '../productPage/Product';

const UserRoutes = (props) => {
    return (
        <Switch>
            <GuestRoutes path="/login" {...props} component={Login} />
            <GuestRoutes path="/register" {...props} component={Register} />
            <PrivateRoute path="/my_account" {...props} component={Profile} />
            <Route exact path="/" render={() => <LandingPage {...props} />} />
            <Route path="/categories" render={() => <Categories {...props} />} />
            <Route path="/*/*/:id" render={() => <ProductPage {...props} />} />
            <Route path="/shop*" render={() => <Shop {...props} />} />
            <Route component={NotFound} />
        </Switch>
    );
}
//change categoreis route to /categories
export default UserRoutes;