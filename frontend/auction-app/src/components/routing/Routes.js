import React from 'react';
import { Route, Switch } from 'react-router-dom';
import PrivateRoute from './PrivateRoute';
import GuestRoutes from './GuestRoutes';
import Login from '../Login/Login'
import Register from '../register/Register';

const UserRoutes = (props) => {
    return (
        <Switch>
            <Route path="/login" render={() => <Login {...props} />} />
            <Route path="/register" render={() => <Register {...props} />} />
        </Switch>
    );
}

export default UserRoutes;