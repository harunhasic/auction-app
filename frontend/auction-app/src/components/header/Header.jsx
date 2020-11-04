import React, { useEffect, useState } from 'react';
import { SiFacebook, SiTwitter, SiInstagram } from 'react-icons/si';
import { GrFormSearch } from "react-icons/gr";
import { Link, NavLink } from 'react-router-dom';
import '../../styles/header/Header.scss';
import { FormControl, Nav, Navbar, Dropdown } from 'react-bootstrap';
import { isTokenValid, removeSession } from '../../utils/LocalStorageUtils'
import { RiAuctionFill } from 'react-icons/ri';

export const getUserName = () => {
    const user = localStorage.getItem('auctionapp-user');
    return user ? JSON.parse(user).firstName : null;
}


const Header = ({ loggedInState }) => {

    const [isLoggedIn, setLoggedIn] = useState(isTokenValid());

    const handleLogout = () => {
        setLoggedIn(false);
        removeSession();
    };

    useEffect(() => {
        if (loggedInState !== null)
            setLoggedIn(!isLoggedIn);
    }, [loggedInState]);

    return (
    <div>
        <div className="header-container">
            <div className="socials-container">
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
            </div>
            <Nav>
                <NavLink exact className="dark-nav-link nav-link" activeClassName="dark-active-nav-link" to="/">HOME</NavLink>
            </Nav>
        </div>
    </div>
);
}

export default Header;