import React from 'react';
import { Image, Table } from 'react-bootstrap';
import moment from 'moment';

import '../../styles/bidding/bidTable.scss'

const BidTable = ({ bids }) => {

    return (
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
                        <td className={i === 0 ? "td-price-green" : "td-price-bold"}>{'$ ' + bid.amount}</td>
                    </tr>
                ))}
            </tbody>
        </Table>
    );
}

export default BidTable;