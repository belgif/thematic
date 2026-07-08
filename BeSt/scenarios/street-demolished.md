# Scenario: whole street is physically demolished

## Before

Street
| ID   | Version | Name           | Status  | From       | Till |
| ---- | ------- | -------------- | ------- | ---------- | ---- |
| S456 | 3       | Rue du Marché  | current | 1984-01-01 | NULL |

Address
| ID   | Version | Status  | From       | Till   | Street | StreetV |
| ---- | ------- | ------- | -----------| ------ | ------ | ------- |
| A123 | 1       | current | 2026-01-01 | NULL   | S456   | 3       |

## After (INSPIRE)

Street
| ID   | Version | Name            | Status  | From       | Till       |
| ---- | ------- | --------------- | ------- | ---------- | ---------- |
| S456 | 3       | Rue du Marché   | current | 1984-01-01 | 2026-07-01 |
| S456 | 4       | Rue du Marché   | retired | 2026-07-01 | NULL       |

Address
| ID   | Version | Status  | From       | Till         | Street | StreetV |
| ---- | ------- | ------- | -----------| ------------ | ------ | ------- |
| A123 | 1       | current | 2026-01-01 | 2026-07-01   | S456   | 3       |
| A123 | 2       | retired | 2026-07-01 | NULL         | S456   | 4       |

## After (Brussels)

Street
| ID   | Version | Name            | Status  | From       | Till       |
| ---- | ------- | --------------- | ------- | ---------- | ---------- |
| S456 | 3       | Rue du Marché   | current | 1984-01-01 | 2026-07-01 |
| S456 | 4       | Rue du Marché   | retired | 2026-07-01 | NULL       |

Address
| ID   | Version | Status  | From       | Till         | Street | StreetV |
| ---- | ------- | ------- | -----------| ------------ | ------ | ------- |
| A123 | 1       | current | 2026-01-01 | 2026-07-01   | S456   | 3       |
| A123 | 2       | retired | 2026-07-01 | NULL         | S456   | 4       |

## After (Flanders)

Street
| ID   | Version | Name            | Status  | From       | Till       |
| ---- | ------- | --------------- | ------- | ---------- | ---------- |
| S456 | 3       | Rue du Marché   | current | 1984-01-01 | 2026-07-01 |
| S456 | 4       | Rue du Marché   | retired | 2026-07-01 | NULL       |

Address
| ID   | Version | Status  | From       | Till         | Street | StreetV |
| ---- | ------- | ------- | -----------| ------------ | ------ | ------- |
| A123 | 1       | current | 2026-01-01 | 2026-07-01   | S456   | 3       |
| A123 | 2       | retired | 2026-07-01 | NULL         | S456   | 4       |

## After (Wallonie)

Street
| ID   | Version | Name            | Status  | From       | Till       |
| ---- | ------- | --------------- | ------- | ---------- | ---------- |
| S456 | 3       | Rue du Marché   | current | 1984-01-01 | 2026-07-01 |
| S456 | 4       | Rue du Marché   | retired | 2026-07-01 | NULL       |

Address
| ID   | Version | Status  | From       | Till         | Street | StreetV |
| ---- | ------- | ------- | -----------| ------------ | ------ | ------- |
| A123 | 1       | current | 2026-01-01 | 2026-07-01   | S456   | 3       |
| A123 | 2       | retired | 2026-07-01 | NULL         | S456   | 4       |
