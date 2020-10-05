
import React from 'react';
import { Route } from 'react-router-dom';
import NotFound from '../notFound/NotFound';
import { isTokenValid } from '../../utils/LocalStorageUtils';


const GuestRoutes = ({ component: Component, path: Path, ...rest }) => {
  return (
    <Route
      path={Path}
      render={() => !isTokenValid() ? <Component {...rest} /> : <NotFound />}
    />
  )
}

export default GuestRoutes;