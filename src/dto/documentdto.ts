import { CategoryDTO } from './categorydto';
import { ExtensionDTO } from './extensiondto';
import { FolderDTO } from './folderdto';
import { UserDTO } from './userdto';

export class DocumentDTO {
    id: number;
    title: string;
    description: string;
    genre: string;
    datePub: Date;
    user: UserDTO;
    folder: FolderDTO;
    category: CategoryDTO;
    extension: ExtensionDTO;
}
