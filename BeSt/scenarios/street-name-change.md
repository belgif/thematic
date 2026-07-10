# Scenario: street name is changed

## Before

Streetname
| ID   | Version | Name           | Status  | From       | Till |
| ---- | ------- | -------------- | ------- | ---------- | ---- |
| S456 | 3       | Rue du Marché  | current | 1984-01-01 | NULL |

Address
| ID   | Version | Status  | From       | Till   | Street | StreetV |
| ---- | ------- | ------- | -----------| ------ | ------ | ------- |
| A123 | 1       | current | 2026-01-01 | NULL   | S456   | 3       |

## After (INSPIRE)

Streetname
| ID   | Version | Name            | Status  | From       | Till       |
| ---- | ------- | --------------- | ------- | ---------- | ---------- |
| S456 | 3       | Rue du Marché   | current | 1984-01-01 | 2026-07-01 |
| S456 | 4       | Avenue Gertrude | current | 2026-07-01 | NULL       |

Address
| ID   | Version | Status  | From       | Till         | Street | StreetV |
| ---- | ------- | ------- | -----------| ------------ | ------ | ------- |
| A123 | 1       | current | 2026-01-01 | 2026-07-01   | S456   | 3       |
| A123 | 2       | current | 2026-07-01 | NULL         | S456   | 4       |


## After (Brussels)

Streetname
| ID   | Version | Name            | Status  | From       | Till       |
| ---- | ------- | --------------- | ------- | ---------- | ---------- |
| S456 | 3       | Rue du Marché   | current | 1984-01-01 | 2026-07-01 |
| S456 | 4       | Rue du Marché   | retired | 2026-07-01 | NULL       |
| S789 | 1       | Avenue Gertrude | current | 2026-07-01 | NULL       |

Address
| ID   | Version | Status  | From       | Till         | Street | StreetV |
| ---- | ------- | ------- | -----------| ------------ | ------ | ------- |
| A123 | 1       | current | 2026-01-01 | 2026-07-01   | S456   | 3       |
| A123 | 2       | current | 2026-07-01 | NULL         | S789   | 1       |

## After (Flanders)

Streetname
| ID   | Version | Name            | Status  | From       | Till       |
| ---- | ------- | --------------- | ------- | ---------- | ---------- |
| S456 | 3       | Rue du Marché   | current | 1984-01-01 | 2026-07-01 |
| S789 | 1       | Avenue Gertrude | current | 2026-07-01 | NULL       |

(check BOSA: is a "retired" added or not": in GRAR "gehistoreerd", does BOSA add a record or not)

Address
| ID   | Version | Status  | From       | Till         | Street | StreetV |
| ---- | ------- | ------- | -----------| ------------ | ------ | ------- |
| A123 | 1       | current | 2026-01-01 | 2026-07-01   | S456   | 3       |
| A123 | 2       | current | 2026-07-01 | NULL         | S789   | 1       |

## After (Wallonie)

Streetname
| ID   | Version | Name            | Status  | From       | Till       |
| ---- | ------- | --------------- | ------- | ---------- | ---------- |
| S456 | 3       | Rue du Marché   | current | 1984-01-01 | 2026-07-01 |
| S456 | 4       | Avenue Gertrude | current | 2026-07-01 | NULL       |

Address
| ID   | Version | Status  | From       | Till         | Street | StreetV |
| ---- | ------- | ------- | -----------| ------------ | ------ | ------- |
| A123 | 1       | current | 2026-01-01 | 2026-07-01   | S456   | 3       |
| A123 | 2       | current | 2026-07-01 | NULL         | S456   | 4       |

(to be verified if there is a retired or not)
