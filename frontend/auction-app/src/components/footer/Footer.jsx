import React from 'react';
import { about, privacy, terms } from '../../utils/RedirectUrls';
import { Link } from 'react-router-dom';
import { SiFacebook, SiTwitter, SiInstagram } from "react-icons/si";
import { IoIosArrowForward } from "react-icons/io";
import { Button, Form } from 'react-bootstrap';
import '../../styles/footer/Footer.scss';

const Footer = () => {
  return (
    <div className="footer-container">
      <div className="footer-content">
        <div className="footer-content-title">
          AUCTION
        </div>
        <Link className="white-nav-link" to={about}>
          About Us
        </Link>
        <Link className="white-nav-link" to={terms}>
          Terms and Conditions
        </Link>
        <Link className="white-nav-link" to={privacy}>
          Privacy and Policy
        </Link>
      </div>

      <div className="footer-content">
        <div className="footer-content-title">
          GET IN TOUCH
        </div>
        Call Us at +123 797-567-2535
        <a className="white-nav-link" target="_blank" rel="noopener noreferrer" href="mailto:support@auction.com">support@auction.com</a>
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
      </div>

      <div className="footer-content">
        <div className="footer-content-title">
          NEWSLETTER
        </div>
        <p>
          Enter your email address and get notified
          <br />
          about new products. We hate spam!
        </p>
        <div className="footer-btn-div">
          <Form.Control className="footer-email" type="text" placeholder="Your Email address" />
          <Button className="footer-button">
            GO
            <IoIosArrowForward className="footer-arrow" />
          </Button>
        </div>
      </div>
    </div>
  );
}

export default Footer;