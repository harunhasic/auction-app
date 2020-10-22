import { getToken } from './LocalStorageUtils';


export const defaultHeader = () => {
    return {
        headers: {
            'Authorization': 'Bearer ' + getToken()
        }
    };
}

export const getParams = (args) => {
    return {
        params: {
            ...args
        }
    };
}