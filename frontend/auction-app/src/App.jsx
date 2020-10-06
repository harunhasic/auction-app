import React, { useState } from 'react';
import { BrowserRouter as Router } from "react-router-dom"
import './App.scss';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Alert, Breadcrumb } from 'react-bootstrap';
import Header from './components/header/Header'
import Routes from './components/routing/Routes'


const App = () => {

  const [loggedInState, setLoggedInState] = useState(null);

  const [alertVisible, setAlertVisible] = useState(false);
  const [variant, setVariant] = useState(null);
  const [message, setMessage] = useState(null);

  const [breadcrumbItems, setBreadcrumbItems] = useState([]);
  const [breadcrumbTitle, setBreadcrumbTitle] = useState(null);

  let keepFlag = false;

  const showMessage = (variant, message) => {
    setMessage(message);
    setVariant(variant);
    setAlertVisible(true);
    keepFlag = true;
  }
  const setBreadcrumb = (title, items) => {
    setBreadcrumbTitle(title);
    setBreadcrumbItems(items);
    removeAlert();
  }

  const deleteBreadcrumb = () => {
    setBreadcrumbTitle(null);
  }

  const removeAlert = () => {
    if (keepFlag === true) {
      keepFlag = false;
    } else {
      setAlertVisible(false);
    }
  }

  const changeLoggedInState = () => {
    if (loggedInState === null) {
      setLoggedInState(false);
      return;
    }
    setLoggedInState(!loggedInState);
  }

  return (
    <div className="app-container">
      <Router>
        <Header loggedInState={loggedInState} />

        <div className={alertVisible && breadcrumbTitle === null ? 'conditional' : null}>
          <Alert dismissible onClose={() => setAlertVisible(false)} transition={false} show={alertVisible} variant={variant}>
            {message}
          </Alert>
        </div>
        <div className="route-container">
          <Routes changeLoggedInState={changeLoggedInState} showMessage={showMessage} setBreadcrumb={setBreadcrumb} removeBreadcrumb={deleteBreadcrumb} />
        </div>
      </Router>
    </div>
  );
}

export default App;