import { decode } from "jsonwebtoken";

// set token and user to local storage
export const setSession = (user, token) => {
    localStorage.setItem('auctionapp-token', token);
    localStorage.setItem('auctionapp-user', JSON.stringify(user));
}

// remove token and user from local storage
export const removeSession = () => {
    localStorage.removeItem('auctionapp-token');
    localStorage.removeItem('auctionapp-user');
};

// return user from the local storage
export const getUser = () => {
    const user = localStorage.getItem('auctionapp-user');
    return user ? JSON.parse(user) : null;
};

// return user id from the local storage
export const getUserId = () => {
    const user = localStorage.getItem('auctionapp-user');
    return user ? JSON.parse(user).id : null;
};

// return token from local storage
export const getToken = () => {
    return localStorage.getItem('auctionapp-token') || null;
}

// checks if token is still valid from local storage
export const validToken = () => {
    const token = getToken();
    if (token === null)
        return false;
    const exp = decode(token, { complete: true }).payload.exp;
    return Date.now() < exp * 1000;
}