import { decode } from "jsonwebtoken";

// function that saves token and user to local storage
export const setSession = (user, token) => {
    localStorage.setItem('auctionapp-token', token);
    localStorage.setItem('auctionapp-user', JSON.stringify(user));
}

// function that removes token and user from local storage
export const removeSession = () => {
    localStorage.removeItem('auctionapp-token');
    localStorage.removeItem('auctionapp-user');
};

// function that returns user from the local storage
export const getUser = () => {
    const user = localStorage.getItem('auctionapp-user');
    return user ? JSON.parse(user) : null;
};

// function that returns user id from the local storage
export const getUserId = () => {
    const user = localStorage.getItem('auctionapp-user');
    return user ? JSON.parse(user).id : null;
};

// function that returns token from local storage
export const getToken = () => {
    return localStorage.getItem('auctionapp-token') || null;
}

// // function that checks if token is still valid from local storage
export const validToken = () => {
    const token = getToken();
    if (token === null)
        return false;
    const exp = decode(token, { complete: true }).payload.exp;
    return Date.now() < exp * 1000;
}
