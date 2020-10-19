import React, { useState } from 'react';
import { BrowserRouter as Router, Link } from "react-router-dom"
import './App.scss';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Alert, Breadcrumb } from 'react-bootstrap';
import Header from './components/header/Header'
import Routes from './components/routing/Routes'
import Footer from './components/footer/Footer'

const App = () => {

  const [loggedInState, setLoggedInState] = useState(null);

  const [alertVisible, setAlertVisible] = useState(false);
  const [variant, setVariant] = useState(null);
  const [message, setMessage] = useState(null);

  const [breadcrumbItems, setBreadcrumbItems] = useState([]);
  const [breadcrumbTitle, setBreadcrumbTitle] = useState(null);

  let keepFlag = false;

  function showMessage(variant, message) {
    setMessage(message);
    setVariant(variant);
    setAlertVisible(true);
    keepFlag = true;
  }
    function setBreadcrumb(title, items) {
    setBreadcrumbTitle(title);
    setBreadcrumbItems(items);
    removeAlert();
  }

    function deleteBreadcrumb() {
    setBreadcrumbTitle(null);
    removeAlert();
  }

  function removeAlert() {
    if (keepFlag === true) {
      keepFlag = false;
    } else {
      setAlertVisible(false);
    }
  }

  function changeLoggedInState() {
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
        <Breadcrumb style={breadcrumbTitle === null ? { display: 'none' } : null}>
          <div className="breadcrumb-title">
            {breadcrumbTitle}
          </div>
          {breadcrumbItems.map((item, i, { length }) => (
            <Breadcrumb.Item active key={item.text}>
              {length - 1 === i ? (
                <div style={{ color: '#252525' }}>
                  {item.text}
                </div>
              ) : (
                  <Link className="dark-nav-link" to={item.href}>
                    {item.text}
                  </Link>
                )}
            </Breadcrumb.Item>
          ))}
        </Breadcrumb>
        <div style={alertVisible && breadcrumbTitle === null ? { marginTop: 40, marginBottom: '-1rem' } : null}>
          <Alert dismissible onClose={() => setAlertVisible(false)} transition={false} show={alertVisible} variant={variant}>
            {message}
          </Alert>
        </div>
        <div className="route-container">
          <Routes changeLoggedInState={changeLoggedInState} setBreadcrumb={setBreadcrumb} showMessage={showMessage} deleteBreadcrumb={deleteBreadcrumb} />
        </div>
        <Footer />
      </Router>
    </div>
  );
}

export default App;