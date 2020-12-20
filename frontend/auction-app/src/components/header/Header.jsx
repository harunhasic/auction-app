import React, { useEffect, useState } from 'react';
import { Link, NavLink } from 'react-router-dom';
import '../../styles/header/Header.scss';
import { Nav, Navbar, Dropdown, FormControl, Image } from 'react-bootstrap';
import { isTokenValid, removeSession } from '../../utils/LocalStorageUtils'
import { RiAuctionFill } from 'react-icons/ri';
import { GrFormSearch } from "react-icons/gr";
import { useHistory } from "react-router";
import {shopUrl, home, about, terms, privacy, registerUrl, loginUrl } from '../../utils/RedirectUrls';
import * as qs from 'query-string';
import { SiFacebook, SiTwitter, SiInstagram } from "react-icons/si";

export const getUserName = () => {
    const user = localStorage.getItem('auctionapp-user');
    return user ? JSON.parse(user).firstName : null;
}

const Header = ({ loggedInState }) => {

    const history = useHistory();

    const [isLoggedIn, setLoggedIn] = useState(isTokenValid());
    const [searchText, setSearchText] = useState("")

    const toHome = () => {
       history.push('/');   
    }   

    function pressEnter(e) {
        if (e.key === "Enter") {
            searchFunction();
        }
    }

    function toShop() {
        history.push('/shop');
    }

    const handleLogout = () => {
        setLoggedIn(false);
        removeSession();
        toHome();
    };

    useEffect(() => {
        const urlParams = qs.parse(history.location.search);
        if (searchText !== urlParams.query)
            setSearchText(urlParams.query);
        if (loggedInState === false)
            setLoggedIn(!isLoggedIn);
    }, [loggedInState]);

    const searchFunction = async () => {
        const urlParams = {
            query: searchText,
            sort: "newness"
        };
        history.push({
            pathname: shopUrl,
            search: qs.stringify(urlParams)
        });
    }
  
    return (
    <div>
        <div className="header-container">
            <div className="socials-container">
              <a className="social-link" rel="noopener noreferrer" href="https://www.facebook.com/AtlantBH" target="_blank">
                <SiFacebook />
              </a>
              <a className="social-link" rel="noopener noreferrer" href="https://twitter.com/atlantbh" target="_blank">
               <SiTwitter />
              </a>
              <a className="social-link" rel="noopener noreferrer" href="https://www.instagram.com/atlantbh" target="_blank">
                <SiInstagram />
              </a>
            </div>
            <Nav>
                {isLoggedIn ?
                    (
                        <div>
                            <div className="row">
                                <div className="welcome-msg">Welcome, </div>
                                <div className="name-msg">{getUserName()}</div>
                                <Dropdown className="col">
                                    <Dropdown.Toggle
                                        size="sm"
                                        variant="secondary"
                                        id="dropdown-basic"
                                        className="dropdown-arrow"
                                    >
                                    </Dropdown.Toggle>
                                    <Dropdown.Menu>
                                        <Dropdown.Item onClick={handleLogout}>Logout</Dropdown.Item>
                                    </Dropdown.Menu>
                                </Dropdown>
                            </div>
                        </div>
                    ) :
                    (
                        <div>
                            <div className="login-account">
                                <Link className="header-text" to="/login">
                                    Login
                                </Link>
                                <Navbar.Text className="header-or">
                                    or
                                </Navbar.Text>
                                <Link className="header-text" to="/register">
                                    Create an account
                                </Link>
                            </div>
                        </div>
                    )}
            </Nav>
        </div>

        <div className="lower-header-container">
            <Link className="col-md-3 lower-header-brand" to="/">
                <RiAuctionFill className="auction-fill" />
                AUCTION
            </Link>
            <div className="col-md-4">
            <div className="lower-header-search">
                    <FormControl
                        value={searchText || ""}
                        onChange={(e) => setSearchText(e.target.value)}
                        size="xl-18"
                        type="text"
                        maxLength="155"
                        placeholder="Try enter: Shoes"
                        onKeyUp={(e) => e.key === 'Enter' ? searchFunction() : null}
                    />
                    <GrFormSearch className="lower-header-search-icon" onClick={searchFunction} />
                </div>
            </div>
            
            <Nav>
            <NavLink
                        isActive={(match, location) => (match.isExact || location.pathname === loginUrl || location.pathname === registerUrl)}
                        className="dark-nav-link nav-link"
                        activeClassName="dark-active-nav-link"
                        to={home}
                    >
                        HOME
                    </NavLink>
                    <NavLink
                        isActive={(match, location) => ((match !== null && match.url === shopUrl) || location.pathname === about || location.pathname === terms ||
                            location.pathname === privacy)}
                        className="dark-nav-link nav-link"
                        activeClassName="dark-active-nav-link"
                        to={shopUrl}
                    >
                        SHOP
                    </NavLink>
            </Nav>
        </div>
    </div>
);
}

export default Header;