import React, { useEffect } from 'react';
import { shopUrl } from '../../utils/RedirectUrls';
import '../../styles/helper/Privacy.scss'

const Privacy = ( {setBreadcrumb} ) => {

    useEffect(() => {
        setBreadcrumb("PRIVACY POLICY", [{ text: "SHOP", href: shopUrl }, { text: "PRIVACY POLICY" }]);
        // eslint-disable-next-line
    }, [])

    return (
        <div className="privacy-container">
            <h1 className="privacy-header">
                Some title here
            </h1>

            <div className="privacy-content">
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum
            </div>
        </div>
    );
}

export default Privacy;