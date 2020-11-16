import React, { useState, useEffect } from 'react';
import { Image, Table } from 'react-bootstrap';
import moment from 'moment';

import '../../styles/bidding/bidTable.scss'
import BidService from '../../Services/bid-service';
import ErrorComponent from '../notFound/ErrorComponent';

const bidService = new BidService();

const BidTable = ({ bids }) => {

    const [highestBid, setHighestBid] = useState(0);
    const [hasError, setHasError] = useState(false);
    const [errorMessage, setErrorMessage] = useState(null);

    useEffect(() => {
        async function fetchData() {
            try {
                const highestBid = await bidService.getHighestBid(bids[0].product.id);
                setHighestBid(highestBid.data);
            } catch (error) {
                setHasError(true);
                setErrorMessage(error.toString());
            }
        }
        fetchData();
    })

return (
    <React.Fragment>
        {
            !hasError ?
                <Table variant="gray-transparent" responsive borderless>
                    <thead className="table-head" >
                        <tr>
                            <td colSpan="2">Bidder</td>
                            <td>Date</td>
                            <td>Bid</td>
                        </tr>
                    </thead>
                    <tbody>
                        {(bids || []).map((bid, i) => (
                            <tr key={bid.id}>
                                <td className="td-class" colSpan="2">
                                    <Image className="user-avatar-photo" src={bid.user.profilePhotoUrl} roundedCircle />
                                    {bid.user.firstName + ' ' + bid.user.lastName}
                                </td>
                                <td>{moment.utc(bid.bidDate).local().format("D MMMM YYYY")}</td>
                                <td className={bid.amount === highestBid ? "td-price-green" : "td-price-bold"}>{'$ ' + bid.amount}</td>
                            </tr>
                        ))}
                    </tbody>
                </Table>
                : <ErrorComponent message={errorMessage}></ErrorComponent>
        }
    </React.Fragment>
  );
}

export default BidTable;