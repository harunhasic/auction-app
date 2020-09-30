import React, { useEffect, useState } from 'react';
import { SiFacebook, SiTwitter, SiInstagram } from 'react-icons/si';
import { Link, NavLink } from 'react-router-dom';
import '../../styles/header/Header.scss';
import { FormControl, Nav, Navbar } from 'react-bootstrap';
import { validToken, removeSession } from '../../Services/CommonService'
import { RiAuctionFill } from 'react-icons/ri';
import { GrFormSearch } from 'react-icons/gr';

const Header = ({ loggedInState }) => {

    const [isLoggedIn, setLoggedIn] = useState(validToken());


    const handleLogout = () => {
        setLoggedIn(false);
        removeSession();
    };

    useEffect(() => {
        if (loggedInState !== null)
            setLoggedIn(!isLoggedIn);

    }, [loggedInState]);


    return (
        <>
            <div className="header-container">
                <div className="socials-container">
                    {/* <a className="social-link"  rel="noopener noreferrer" href="https://www.facebook.com/AtlantBH" target="_blank">
                        <SiFacebook />
                    </a>
                    <a className="social-link"  rel="noopener noreferrer" href="https://twitter.com/atlantbh" target="_blank">
                        <SiTwitter />
                    </a>
                    <a className="social-link"  rel="noopener noreferrer" href="https://www.instagram.com/atlantbh" target="_blank">
                        <SiInstagram />
                    </a> */}
                </div>
                <Nav>
                    {isLoggedIn ?
                        (
                            <>
                                <Link className="header-logout" onClick={handleLogout} to="/">
                                    Log out
                                </Link>
                            </>
                        ) :
                        (
                            <>
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
                            </>
                        )}
                </Nav>
            </div>
            <div className="lower-header-container">
                <Link className="col-md-4 lower-header-brand" to="/">
                    <RiAuctionFill style={{ color: '#C4BFD6', marginRight: 5 }} />
                    AUCTION
                </Link>
                <div className="col-md-4">
                    <FormControl size="xl-18" type="text" placeholder="Try enter: Shoes" />
                    <GrFormSearch className="lower-header-search-icon" />
                </div>
                <Nav>
                    <NavLink exact className="black-nav-link nav-link" activeClassName="black-active-nav-link" to="/">HOME</NavLink>
                    <NavLink className="black-nav-link nav-link" activeClassName="black-active-nav-link" to="/shop">SHOP</NavLink>
                    <NavLink className="black-nav-link nav-link" activeClassName="black-active-nav-link" to="/profile">MY ACCOUNT</NavLink>
                </Nav>
            </div>

        </>
    );
}

export default Header;