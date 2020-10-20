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
import Profile from '../MyProfile/Profile'


const UserRoutes = (props) => {
    return (
        <Switch>
            <Route exact path="/" render={() => <LandingPage {...props} />} />
            <Route path="/all" render={() => <Categories {...props} />} />
            <Route path="/shop*" render={() => <Shop {...props} />} />
            <GuestRoutes path="/login" {...props} component={Login} />
            <GuestRoutes path="/register" {...props} component={Register} />
            <PrivateRoute path="/my_account" {...props} component={Profile} />
            <Route component={NotFound} />
        </Switch>
    );
}

export default UserRoutes;