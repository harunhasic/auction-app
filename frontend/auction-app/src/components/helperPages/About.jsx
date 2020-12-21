  
import React, { useEffect } from 'react';
import { Image } from 'react-bootstrap';
import { shopUrl } from '../../utils/RedirectUrls';

import '../../styles/helper/About.scss';

const About = ({setBreadcrumb}) => {
 

    useEffect(() => {
        setBreadcrumb("ABOUT US", [{ text: "SHOP", href: shopUrl }, { text: "ABOUT US" }]);
        // eslint-disable-next-line
    }, [])

    return (
        <>
            <h1 className="heading">
                About Us
            </h1>
            <div className="about-container">
                <div className="about-text">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis consequat pretium turpis, in eleifend mi laoreet sed. Donec ipsum mauris, venenatis sit amet porttitor id, laoreet eu magna. In convallis diam volutpat libero tincidunt semper. Ut aliquet erat rutrum, venenatis lacus ut, ornare lectus. Quisque congue ex sit amet diam malesuada, eget laoreet quam molestie. In id elementum turpis. Curabitur quis tincidunt mauris. Duis pharetra a odio vitae consectetur. Nullam vitae lacinia nisi, at porta sapien. Etiam vehicula augue at lacus tempus euismod. Nullam sit amet eros ut metus pulvinar volutpat et elementum lacus. Cras mauris mi, vulputate ac justo vitae, fringilla vestibulum sapien. Sed hendrerit nulla id luctus placerat. Sed venenatis ornare augue, et viverra dolor ullamcorper id. Duis id quam hendrerit, mollis ex ut, varius ipsum.
                    <br />
                    <br />
                    Etiam bibendum viverra nulla, at cursus leo fringilla eget. In pellentesque viverra elit id vestibulum. Sed eget leo suscipit, commodo urna vitae, efficitur ligula. Pellentesque non mauris blandit, ultrices nibh consectetur, auctor velit. Nunc ac justo lacus. Vivamus et gravida ante. Quisque cursus augue ligula, aliquam ullamcorper enim ultricies sit amet. In placerat sapien eu ligula commodo pharetra. Nunc et facilisis dolor, ut condimentum metus. Phasellus lacinia efficitur diam sed pharetra. Nullam euismod magna at mauris hendrerit scelerisque vitae vel leo. Cras interdum tellus in sapien fermentum consequat.
                </div>
                <div className="about-images-container">
                    <Image style={{ marginBottom: 20 }} width="100%" src="https://pbs.twimg.com/media/ESk5f3ZWkAA1k1_.jpg" />
                    <Image className="small-about-image" src="https://www.hocu.ba/wp-content/uploads/2017/11/ATLANTBH-1.jpg" />
                    <Image className="small-about-image" src="https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/pop-best-keyboards-1594828389.jpg?crop=1xw:0.9995201535508638xh;center,top&resize=1200:*" />
                </div>
            </div>
        </>
    );
}

export default About;