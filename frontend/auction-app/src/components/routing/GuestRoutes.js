
import React from 'react';
import { Route } from 'react-router-dom';
import NotFound from '../notFound/NotFound';
import { validToken } from '../../Services/CommonService';


const GuestRoutes = ({ component: Component, path: Path, ...rest }) => {
  return (
    <Route
      path={Path}
      render={() => !validToken() ? <Component {...rest} /> : <NotFound />}
    />
  )
}

export default GuestRoutes;