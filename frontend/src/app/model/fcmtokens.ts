import { Accounts } from "./accounts";

export interface FcmTokens{
    id: string;
    account: Accounts;
    token: string;
    timestamp: Date;
}